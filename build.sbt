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
      scalaJSUseMainModuleInitializer := true,
      scalaJSLinkerConfig ~= (
      _.withSourceMap(false) /* disabled because it somehow triggers many warnings */
        // .withModuleKind(ModuleKind.CommonJSModule) //TODO review
      ),
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
