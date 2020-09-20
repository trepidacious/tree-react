import java.nio.file.Files
import java.nio.file.StandardCopyOption.REPLACE_EXISTING

name := "tree-react root project"

ThisBuild / version := "0.0.1-SNAPSHOT"
ThisBuild / organization := "org.rebeam"
ThisBuild / scalaVersion := "2.13.2"
ThisBuild / scalacOptions ++= ScalacOptions.flags

testOptions in Test += Tests.Argument(TestFrameworks.ScalaCheck, "-verbosity", "2")

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

// both intellij and ci needs this to not OOM during initial import since we have so many projects
Global / concurrentRestrictions ++= {
  val gigabytes = (java.lang.Runtime.getRuntime.maxMemory) / (1000 * 1000 * 1000)
  val numParallel = Math.max(1, gigabytes.toInt)
  List(Tags.limit(ScalablyTypedTag, numParallel))
}

// Uncomment if you want to remove debug output
//Global / stQuiet := true

/**
  * Custom task to start demo with webpack-dev-server, use as `<project>/start`.
  * Just `start` also works, and starts all frontend demos
  *
  * After that, the incantation is this to watch and compile on change:
  * `~<project>/fastOptJS::webpack`
  */
lazy val start = TaskKey[Unit]("start")

/** Say just `dist` or `<project>/dist` to make a production bundle in
  * `docs` for github publishing
  */
lazy val dist = TaskKey[File]("dist")

lazy val baseSettings: Project => Project =
  _.enablePlugins(ScalaJSPlugin)
    .settings(
      // version := "0.1-SNAPSHOT",
      // scalaVersion := "2.13.1",
      // scalacOptions ++= ScalacOptions.flags,
      scalaJSUseMainModuleInitializer := true,
      scalaJSLinkerConfig ~= (
      _.withSourceMap(false) /* disabled because it somehow triggers many warnings */
        // .withModuleKind(ModuleKind.CommonJSModule) //TODO review
      ),
      /* for slinky */
      // libraryDependencies ++= Seq("me.shadaj" %%% "slinky-hot" % "0.6.4+2-3c8aef65"),
    )

lazy val bundlerSettings: Project => Project =
  _.settings(
    Compile / fastOptJS / webpackExtraArgs += "--mode=development",
    Compile / fullOptJS / webpackExtraArgs += "--mode=production",
    Compile / fastOptJS / webpackDevServerExtraArgs += "--mode=development",
    Compile / fullOptJS / webpackDevServerExtraArgs += "--mode=production",
    useYarn := true
  )

// Settings for a js-only project
lazy val jsProject: Project => Project =
  _.enablePlugins(
    ScalaJSPlugin
  )

lazy val reactNpmDeps: Project => Project =
  _.settings(
    Compile / npmDependencies ++= Seq(
      "react" -> "16.13.1",
      "react-dom" -> "16.13.1",
      "@types/react" -> "16.9.42",
      "@types/react-dom" -> "16.9.8",
      "csstype" -> "2.6.11",
      "@types/prop-types" -> "15.7.3"
    )
  )

lazy val withCssLoading: Project => Project =
  _.settings(
    /* custom webpack file to include css */
    webpackConfigFile := Some((ThisBuild / baseDirectory).value / "custom.webpack.config.js"),
    Compile / npmDevDependencies ++= Seq(
      "webpack-merge" -> "4.2.2",
      "css-loader" -> "3.4.2",
      "style-loader" -> "1.1.3",
      "file-loader" -> "5.1.0",
      "url-loader" -> "3.0.0"
    )
  )

/**
  * Implement the `start` and `dist` tasks defined above.
  * Most of this is really just to copy the index.html file around.
  */
lazy val browserProject: Project => Project =
  _.settings(
    start := {
      (Compile / fastOptJS / startWebpackDevServer).value
    },
    dist := {
      val artifacts = (Compile / fullOptJS / webpack).value
      val artifactFolder = (Compile / fullOptJS / crossTarget).value
      val distFolder = (ThisBuild / baseDirectory).value / "dist" / moduleName.value

      distFolder.mkdirs()
      artifacts.foreach { artifact =>
        val target = artifact.data.relativeTo(artifactFolder) match {
          case None          => distFolder / artifact.data.name
          case Some(relFile) => distFolder / relFile.toString
        }

        Files.copy(artifact.data.toPath, target.toPath, REPLACE_EXISTING)
      }

      val indexFrom = baseDirectory.value / "src/main/js/index.html"
      val indexTo = distFolder / "index.html"

      val indexPatchedContent = {
        import collection.JavaConverters._
        Files
          .readAllLines(indexFrom.toPath, IO.utf8)
          .asScala
          .map(_.replaceAllLiterally("-fastopt-", "-opt-"))
          .mkString("\n")
      }

      Files.write(indexTo.toPath, indexPatchedContent.getBytes(IO.utf8))
      distFolder
    }
  )




lazy val root = project.in(file(".")).
  aggregate(
    treeProgramJS, treeCoreJVM,
    treeCoreJS, treeCoreJVM,
    treeOTJS, treeOTJVM,
    treeSlinky,
    treeSlinkyExtra,
    treeServer,
    // antdApp,
    // scalajsElectronJS, scalajsElectronJVM,
    // scalajsElectronReactJS, scalajsElectronReactJVM,
    // electronAppJS, electronAppJVM,
    // suiElectronAppJS, suiElectronAppJVM,
    // suiApp
  ).settings(
    publish := {},
    publishLocal := {}
  )

  //////////////////
 // tree-program //
//////////////////
lazy val treeProgram = crossProject(JSPlatform, JVMPlatform).in(
  file("tree-program")
//Settings for all projects
).settings(
  name := "tree-program",

  Deps.test,
  Deps.logging,
  Deps.cats,

  Deps.kindProjector,

).jvmSettings(

).jsSettings(
  //Produce a module, so we can use @JSImport.
  scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
).dependsOn(treeOT)

lazy val treeProgramJVM = treeProgram.jvm
lazy val treeProgramJS = treeProgram.js

  ////////////////
 // tree-core //
///////////////
lazy val treeCore = crossProject(JSPlatform, JVMPlatform).in(
  file("tree-core")
//Settings for all projects
).settings(
  name := "tree-core",

  Deps.test,
  Deps.logging,
  Deps.circe,
  Deps.cats,
  Deps.shapeless,
  Deps.monocle,

  Deps.kindProjector,

).jvmSettings(

).jsSettings(
  //Produce a module, so we can use @JSImport.
  scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
).dependsOn(treeOT, treeProgram)

  //////////////////
 // tree-server //
/////////////////
lazy val treeServer = project.in(
  file("tree-server")
//Settings for all projects
).settings(
  name := "tree-server",

  Deps.test,
  Deps.logging,
  Deps.circe,
  Deps.cats,
  Deps.shapeless,
  Deps.monocle,

  Deps.kindProjector,

).dependsOn(treeCoreJVM)

lazy val treeCoreJVM = treeCore.jvm
lazy val treeCoreJS = treeCore.js

  /////////////
 // tree-ot //
/////////////
lazy val treeOT = crossProject(JSPlatform, JVMPlatform).in(file("tree-ot")).
  //Settings for all projects
  settings(
  name := "tree-ot",

  Deps.test,
  Deps.cats, 
  
).jvmSettings(

).jsSettings(
  //Produce a module, so we can use @JSImport.
  scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
)

lazy val treeOTJVM = treeOT.jvm
lazy val treeOTJS = treeOT.js

lazy val treeSlinky = project.in(
  file("tree-slinky")
).configure(
  baseSettings
).settings(
  name := "tree-slinky",
  Deps.logging,
  Deps.slinky
).dependsOn(treeCoreJS)

lazy val treeSlinkyExtra = project.in(
  file("tree-slinky-extra")
).configure(
  baseSettings
).settings(
  name := "tree-slinky-extra",
  Deps.logging,
  Deps.slinky
).dependsOn(treeSlinky)

// lazy val treeSlinkyExtra = project
//   .in(file("tree-slinky-extra"))
//   .enablePlugins(ScalablyTypedConverterPlugin)
//   .configure(
//     baseSettings, bundlerSettings, browserProject, withCssLoading, reactNpmDeps
//   )
//   .settings(
//     name := "tree-slinky-extra",
//     Deps.logging,
//     Deps.slinky,
//     stFlavour := Flavour.Slinky,
//     Compile / npmDependencies ++= Seq("antd" -> "4.3.1")
//   )
//   .dependsOn(treeSlinky)

lazy val antdApp = project
  .in(file("antd-app"))
  .enablePlugins(ScalablyTypedConverterPlugin)
  .configure(
    baseSettings, bundlerSettings, browserProject, withCssLoading, reactNpmDeps
  )
  .settings(
    stFlavour := Flavour.Slinky,
    Compile / npmDependencies ++= Seq("antd" -> "4.5.1"),
    webpackDevServerPort := 8080,
  )
  .dependsOn(treeSlinkyExtra)

// lazy val bootstrapApp = project.in(
//     file("bootstrap-app")
//   ).configure(
//     baseSettings, bundlerSettings, browserProject, withCssLoading, reactNpmDeps
//   ).settings(
//     webpackDevServerPort := 8080,
//     stFlavour := Flavour.Slinky,
//     Compile / npmDependencies ++= Seq("react-bootstrap" -> "1.0.0", "bootstrap" -> "4.4.1")
//   ).dependsOn(treeSlinky)


//   ///////////////////////
//  // tree-slinky-extra //
// ///////////////////////
// lazy val treeSlinkyExtra = crossProject(JSPlatform, JVMPlatform).in(
//   file("tree-slinky-extra")
//   //Settings for all projects
// ).configure(
//   jsProject
// ).settings(
//   name := "tree-slinky-extra",
//   loggingDeps,
// ).jvmSettings(

// ).jsSettings(
//   //Produce a module, so we can use @JSImport.
//   scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
//   stFlavour := Flavour.Slinky,
//   Compile / npmDependencies ++= Seq("antd" -> "3.26.0")
// ).dependsOn(treeSlinky)

// lazy val treeSlinkyExtraJVM = treeSlinkyExtra.jvm
// lazy val treeSlinkyExtraJS = treeSlinkyExtra.js


// lazy val antd =
//   project
//     .configure(baseSettings, bundlerSettings, browserProject, withCssLoading, reactNpmDeps)
//     .settings(
//       webpackDevServerPort := 8006,
//       stFlavour := Flavour.Slinky,
//       Compile / npmDependencies ++= Seq("antd" -> "3.26.0")
//     )





  //////////////////////
 // scalajs-electron //
//////////////////////
// TODO use scalablyt-typed node project instead of nodejs?
// lazy val scalajsElectron = crossProject(JSPlatform, JVMPlatform).in(file("scalajs-electron")).
//   //Settings for all projects
//   settings(
//     name := "scalajs-electron"

//   ).jvmSettings(

//   ).jsSettings(
//     libraryDependencies ++= Seq(
//       "org.typelevel"               %%% "cats-core"         % catsVersion,
//       "org.typelevel"               %%% "cats-effect"       % catsEffectVersion,
//       "io.scalajs"                  %%% "nodejs"            % nodejsVersion
//     ),

//     //Produce a module, so we can use @JSImport.
//     scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
//   )

// lazy val scalajsElectronJVM = scalajsElectron.jvm
// lazy val scalajsElectronJS = scalajsElectron.js


  /////////////////////////////
 // scalajs-electron-react //
////////////////////////////
// lazy val scalajsElectronReact = crossProject(JSPlatform, JVMPlatform).in(file("scalajs-electron-react")).
//   //Settings for all projects
//   settings(
//     name := "scalajs-electron-react"

//   ).jvmSettings(

//   ).jsSettings(
//     //Produce a module, so we can use @JSImport.
//     scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }

//   ).dependsOn(scalajsElectron, scalajsReactMaterialUIExtra)

// lazy val scalajsElectronReactJVM = scalajsElectronReact.jvm
// lazy val scalajsElectronReactJS = scalajsElectronReact.js


  //////////////////
 // electron-app //
//////////////////
// lazy val electronApp = crossProject(JSPlatform, JVMPlatform).in(file("electron-app")).
//   //Settings for all projects
//   settings(
//   name := "electron-app",

// ).jvmSettings(

// ).jsSettings(

// //  Alternative approach - output all scalajs and js dependencies to source folder for electron-app project
// //  artifactPath below is preferred, since it only moves the non-test files, and omits dependencies, which we don't use.
// //  crossTarget in (Compile, fullOptJS) := scalaJsSrcDir,
// //  crossTarget in (Compile, fastOptJS) := scalaJsSrcDir,
// //  crossTarget in (Compile, packageJSDependencies) := scalaJsSrcDir,

//   // Move just the required artifacts to scalajs_src for electron project to use. This allows us to include that
//   // directory in the electron app, and include only the minimal required files. Note the baseDirectory for the
//   // js project is "js" in the root project directory, hence the "..". 
//   artifactPath in (Compile, fastOptJS) := baseDirectory.value / ".." / "scalajs_src" / "fastOpt.js",
//   artifactPath in (Compile, fullOptJS) := baseDirectory.value / ".." / "scalajs_src" / "fullOpt.js",

//   //Produce a module, so we can use @JSImport.
//   scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }

// ).dependsOn(scalajsElectron, scalajsElectronReact, scalajsReactMaterialUIExtra, treeReact, scalajsReactSemanticUI)

// lazy val electronAppJVM = electronApp.jvm
// lazy val electronAppJS = electronApp.js


  //////////////////////
 // sui-electron-app //
//////////////////////
// lazy val suiElectronApp = crossProject(JSPlatform, JVMPlatform).in(file("sui-electron-app")).
//   //Settings for all projects
//   settings(
//   name := "sui-electron-app",

// ).jvmSettings(

// ).jsConfigure(
//    _.enablePlugins(ScalaJSBundlerPlugin)
// ).jsSettings(

//    webpackConfigFile :=
//      Some(baseDirectory.value / "src" / "main" / "resources" / "electron.webpack.config.js"),

//    // Move just the required artifacts to scalajs_src for electron project to use. This allows us to include that
//   // directory in the electron app, and include only the minimal required files. Note the baseDirectory for the
//   // js project is "js" in the root project directory, hence the "..".
// //  artifactPath in (Compile, fastOptJS) := baseDirectory.value / ".." / "scalajs_src" / "fastOpt.js",
// //  artifactPath in (Compile, fullOptJS) := baseDirectory.value / ".." / "scalajs_src" / "fullOpt.js",
// //
// //  //Produce a module, so we can use @JSImport.
// //  scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }

//    scalaJSUseMainModuleInitializer := true,

//    // TODO use a main method instead, and make this do everything?
//    // Respect the export points so we can require from electron
//    // See https://scalacenter.github.io/scalajs-bundler/cookbook.html#several-entry-points
// //   webpackBundlingMode := BundlingMode.LibraryAndApplication(),


//    scalaJSModuleKind := ModuleKind.CommonJSModule,

//    npmDependencies in Compile ++= Seq(
//      "downshift" -> "^2.1.5",
//      "electron-is-dev" -> "^0.3.0",
//      "electron-log" -> "^2.2.17",
//      "electron-updater" -> "^3.1.2",
//      "react" -> "^16.5.1",
//      "react-dom" -> "^16.5.1",
//      "semantic-ui-css" -> "^2.4.1",
//      "semantic-ui-react" -> "^0.87.1"
//    )

//  ).dependsOn(scalajsElectron, scalajsElectronReact, scalajsReactMaterialUIExtra, treeReact, scalajsReactSemanticUI)

// lazy val suiElectronAppJVM = suiElectronApp.jvm
// lazy val suiElectronAppJS = suiElectronApp.js

// lazy val antdApp =
//   project.in(file("antd-app"))
//     .configure(jsProject, bundlerSettings, browserProject, withCssLoading)
//     .settings(
//       webpackDevServerPort := 8080,
//       libraryDependencies ++= Seq(
//         ScalablyTyped.A.`antd-slinky-facade`,
//         ScalablyTyped.R.`react-dom`,
//       ),
//       Compile / npmDependencies ++= Seq(
//         "react" -> "16.8",
//         "react-dom" -> "16.8",
//         "prop-types" -> "^15.0.0",
//       )
//     ).dependsOn(treeSlinkyJS, treeSlinkyExtraJS)

// lazy val suiApp =
//   project.in(file("sui-app"))
//     .configure(jsProject, bundlerSettings, browserProject, withCssLoading)
//     .settings(
//       scalaCSSDeps,
//       webpackDevServerPort := 8081,
//       Compile / npmDependencies ++= Seq(
//         "downshift" -> "^2.1.5",
//         "react" -> "^16.5.1",
//         "react-dom" -> "^16.5.1",
//         "semantic-ui-css" -> "^2.4.1",
//         "semantic-ui-react" -> "^0.87.1"
        
//       )
//     ).dependsOn(treeReactJS, scalajsReactSemanticUIJS)
