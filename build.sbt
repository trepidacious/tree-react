import sbtcrossproject.CrossPlugin.autoImport.crossProject



name := "tree-react root project"
version in ThisBuild := "0.0.1-SNAPSHOT"
organization in ThisBuild := "org.rebeam"
scalaVersion in ThisBuild := "2.12.8"
// crossScalaVersions in ThisBuild := Seq("2.11.12", "2.12.6")


scalacOptions in ThisBuild ++= Seq(
  "-feature",
  "-deprecation",
  "-encoding", "UTF-8",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Xcheckinit",
  "-Xlint:-unused",
  "-Ywarn-unused:imports",
  "-Ypartial-unification",
  "-language:existentials",
  "-language:higherKinds",
  "-Yno-adapted-args",
  // "-Ywarn-dead-code",  //TODO restore for JVM and shared only
  // "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture"
  //"-Yno-predef" ?
)

testOptions in Test += Tests.Argument(TestFrameworks.ScalaCheck, "-verbosity", "2")

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

lazy val catsVersion                = "1.5.0"
lazy val catsEffectVersion          = "1.1.0"
lazy val scalajsReactVersion        = "1.3.1"
lazy val circeVersion               = "0.10.0"
lazy val nodejsVersion              = "0.4.2"
lazy val scalacssVersion            = "0.5.3"
lazy val shapelessVersion           = "2.3.3"
lazy val monocleVersion             = "1.5.0-cats"
lazy val scalacticVersion           = "3.0.5" // Needed?
lazy val scalatestVersion           = "3.0.5"
lazy val scalacheckVersion          = "1.14.0"
lazy val log4sVersion               = "1.6.1"
lazy val kindProjectorVersion       = "0.9.8"

lazy val scalajsReactDeps = Seq(
  libraryDependencies ++= Seq(
    "com.github.japgolly.scalajs-react" %%% "core" % scalajsReactVersion,
    "com.github.japgolly.scalajs-react" %%% "extra" % scalajsReactVersion,
  )
)

lazy val scalaCSSDeps = Seq(
  libraryDependencies += "com.github.japgolly.scalacss"      %%% "ext-react" % scalacssVersion
)

lazy val testDeps = Seq(
  libraryDependencies ++= Seq(
    "org.scalactic"               %%% "scalactic"         % scalacticVersion    % "test",
    "org.scalatest"               %%% "scalatest"         % scalatestVersion    % "test",
    "org.scalacheck"              %%% "scalacheck"        % scalacheckVersion   % "test"
  )
)

lazy val root = project.in(file(".")).
  aggregate(
    scalajsReactSemanticUIJS, scalajsReactSemanticUIJVM,
    scalajsReactMaterialUIJS, scalajsReactMaterialUIJVM,
    scalajsReactDocgenFacadeJS, scalajsReactDocgenFacadeJVM,
    scalajsReactMaterialIconsJS, scalajsReactMaterialIconsJVM,
    scalajsReactDownshiftJS, scalajsReactDownshiftJVM, 
    scalajsReactMaterialUIExtraJS, scalajsReactMaterialUIExtraJVM,
    scalajsElectronJS, scalajsElectronJVM,
    scalajsElectronReactJS, scalajsElectronReactJVM,
    treeCoreJS, treeCoreJVM,
    treeOTJS, treeOTJVM,
    treeReactJS, treeReactJVM,
    electronAppJS, electronAppJVM,
    suiElectronAppJS, suiElectronAppJVM
  ).settings(
    publish := {},
    publishLocal := {}
  )


  ///////////////////////////////
 // scalajs-react-material-ui //
///////////////////////////////
lazy val scalajsReactMaterialUI = crossProject(JSPlatform, JVMPlatform).in(file("scalajs-react-material-ui")).
  settings(
    name := "scalajs-react-material-ui"

  ).jvmSettings(
    mainClass := Some("org.rebeam.Generate"),

    libraryDependencies ++= Seq(
      "io.circe"                    %%% "circe-core"        % circeVersion,
      "io.circe"                    %%% "circe-generic"     % circeVersion,
      "io.circe"                    %%% "circe-parser"      % circeVersion,

      "org.typelevel"               %%% "cats-core"         % catsVersion,
      "org.typelevel"               %%% "cats-effect"       % catsEffectVersion
    ),

    //For Circe
    addCompilerPlugin("org.scalamacros" %% "paradise" % "2.1.0" cross CrossVersion.patch)

  ).jsSettings(
    //Scalajs dependencies that are used on the client only
    resolvers += Resolver.jcenterRepo,

    scalajsReactDeps,
    
    //Produce a module, so we can use @JSImport on material-ui
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
  )

lazy val scalajsReactMaterialUIJVM = scalajsReactMaterialUI.jvm
lazy val scalajsReactMaterialUIJS = scalajsReactMaterialUI.js

///////////////////////////////
// scalajs-react-material-ui //
///////////////////////////////
lazy val scalajsReactDocgenFacade = crossProject(JSPlatform, JVMPlatform).in(file("scalajs-react-docgen-facade")).
  settings(
    name := "scalajs-react-docgen-facade"

  ).jvmSettings(
  mainClass := Some("org.rebeam.Generate"),

  libraryDependencies ++= Seq(
    "io.circe"                    %%% "circe-core"        % circeVersion,
    "io.circe"                    %%% "circe-generic"     % circeVersion,
    "io.circe"                    %%% "circe-parser"      % circeVersion,

    "org.typelevel"               %%% "cats-core"         % catsVersion,
    "org.typelevel"               %%% "cats-effect"       % catsEffectVersion,
    "org.reflections"             % "reflections"         % "0.9.11"
  ),

  //For Circe
  addCompilerPlugin("org.scalamacros" %% "paradise" % "2.1.0" cross CrossVersion.patch)

).jsSettings(
  //Scalajs dependencies that are used on the client only
  resolvers += Resolver.jcenterRepo,

  scalajsReactDeps,

  //Produce a module, so we can use @JSImport on material-ui
  scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
).dependsOn(scalajsReactCommon)

lazy val scalajsReactDocgenFacadeJVM = scalajsReactDocgenFacade.jvm
lazy val scalajsReactDocgenFacadeJS = scalajsReactDocgenFacade.js

///////////////////////////////
// scalajs-react-semantic-ui //
///////////////////////////////
lazy val scalajsReactSemanticUI = crossProject(JSPlatform, JVMPlatform).in(file("scalajs-react-semantic-ui")).
  settings(
    name := "scalajs-react-semantic-ui"

  ).jsSettings(
    //Scalajs dependencies that are used on the client only
    resolvers += Resolver.jcenterRepo,
  
    scalajsReactDeps,
  
    //Produce a module, so we can use @JSImport on material-ui
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
  ).dependsOn(scalajsReactCommon)

lazy val scalajsReactSemanticUIJVM = scalajsReactSemanticUI.jvm
lazy val scalajsReactSemanticUIJS = scalajsReactSemanticUI.js

///////////////////////////////
// scalajs-react-common //
///////////////////////////////
lazy val scalajsReactCommon = crossProject(JSPlatform, JVMPlatform).in(file("scalajs-react-common")).
  settings(
    name := "scalajs-react-common"

  ).jsSettings(
  //Scalajs dependencies that are used on the client only
  resolvers += Resolver.jcenterRepo,

  scalajsReactDeps,

  //Produce a module, so we can use @JSImport on material-ui
  scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
)

lazy val scalajsReactCommonJVM = scalajsReactCommon.jvm
lazy val scalajsReactCommonJS = scalajsReactCommon.js


  //////////////////////////////////
 // scalajs-react-material-icons //
//////////////////////////////////
lazy val scalajsReactMaterialIcons = crossProject(JSPlatform, JVMPlatform).in(file("scalajs-react-material-icons")).
  //Settings for all projects
  settings(
    name := "scalajs-react-material-icons",

  ).jvmSettings(
      mainClass := Some("org.rebeam.Generate")

  ).jsSettings(
    //Scalajs dependencies that are used on the client only
    resolvers += Resolver.jcenterRepo,

    scalajsReactDeps,
    
    //Produce a module, so we can use @JSImport.
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
  )

lazy val scalajsReactMaterialIconsJVM = scalajsReactMaterialIcons.jvm
lazy val scalajsReactMaterialIconsJS = scalajsReactMaterialIcons.js



  /////////////////////////////
 // scalajs-react-downshift //
/////////////////////////////
lazy val scalajsReactDownshift = crossProject(JSPlatform, JVMPlatform).in(file("scalajs-react-downshift")).
  //Settings for all projects
  settings(
    name := "scalajs-react-downshift"

  ).jvmSettings(

  ).jsSettings(
    //Scalajs dependencies that are used on the client only
    resolvers += Resolver.jcenterRepo,

    scalajsReactDeps,
    
    //Produce a module, so we can use @JSImport.
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
  )

lazy val scalajsReactDownshiftJVM = scalajsReactDownshift.jvm
lazy val scalajsReactDownshiftJS = scalajsReactDownshift.js



  /////////////////////////////////////
 // scalajs-react-material-ui-extra //
/////////////////////////////////////
lazy val scalajsReactMaterialUIExtra = crossProject(JSPlatform, JVMPlatform).in(file("scalajs-react-material-ui-extra")).
  //Settings for all projects
  settings(
    name := "scalajs-react-material-ui-extra"

  ).jvmSettings(

  ).jsSettings(

     //Scalajs dependencies that are used on the client only
     resolvers += Resolver.jcenterRepo,

    scalajsReactDeps,
    scalaCSSDeps,

    //Produce a module, so we can use @JSImport.
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }

  ).dependsOn(scalajsReactMaterialUI, scalajsReactMaterialIcons, scalajsReactDownshift)

lazy val scalajsReactMaterialUIExtraJVM = scalajsReactMaterialUIExtra.jvm
lazy val scalajsReactMaterialUIExtraJS = scalajsReactMaterialUIExtra.js



  //////////////////////
 // scalajs-electron //
//////////////////////
lazy val scalajsElectron = crossProject(JSPlatform, JVMPlatform).in(file("scalajs-electron")).
  //Settings for all projects
  settings(
    name := "scalajs-electron"

  ).jvmSettings(

  ).jsSettings(
    libraryDependencies ++= Seq(
      "org.typelevel"               %%% "cats-core"         % catsVersion,
      "org.typelevel"               %%% "cats-effect"       % catsEffectVersion,
      "io.scalajs"                  %%% "nodejs"            % nodejsVersion
    ),

    //Produce a module, so we can use @JSImport.
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
  )

lazy val scalajsElectronJVM = scalajsElectron.jvm
lazy val scalajsElectronJS = scalajsElectron.js



  /////////////////////////////
 // scalajs-electron-react //
////////////////////////////
lazy val scalajsElectronReact = crossProject(JSPlatform, JVMPlatform).in(file("scalajs-electron-react")).
  //Settings for all projects
  settings(
    name := "scalajs-electron-react"

  ).jvmSettings(

  ).jsSettings(
    //Produce a module, so we can use @JSImport.
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }

  ).dependsOn(scalajsElectron, scalajsReactMaterialUIExtra)

lazy val scalajsElectronReactJVM = scalajsElectronReact.jvm
lazy val scalajsElectronReactJS = scalajsElectronReact.js



  ////////////////
 // tree-core //
///////////////
lazy val treeCore = crossProject(JSPlatform, JVMPlatform).in(file("tree-core")).
  //Settings for all projects
  settings(
  name := "tree-core",

  testDeps,

   //  libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5",
  libraryDependencies ++= Seq(
    "io.circe"                    %%% "circe-core"        % circeVersion,
    "io.circe"                    %%% "circe-generic"     % circeVersion,
    "io.circe"                    %%% "circe-parser"      % circeVersion,

    "org.typelevel"               %%% "cats-free"         % catsVersion,

    "com.chuusai"                 %%% "shapeless"         % shapelessVersion,

    "com.github.julien-truffaut"  %%% "monocle-core"      % monocleVersion,
    "com.github.julien-truffaut"  %%% "monocle-generic"   % monocleVersion,
    "com.github.julien-truffaut"  %%% "monocle-macro"     % monocleVersion,
    "com.github.julien-truffaut"  %%% "monocle-state"     % monocleVersion,
    "com.github.julien-truffaut"  %%% "monocle-refined"   % monocleVersion,
    "com.github.julien-truffaut"  %%% "monocle-law"       % monocleVersion      % "test"
  ),

  addCompilerPlugin(
    "org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.patch
  ),

  addCompilerPlugin(
    "org.spire-math" %% "kind-projector" % kindProjectorVersion cross CrossVersion.binary
  )

).jvmSettings(

).jsSettings(
  //Produce a module, so we can use @JSImport.
  scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
).dependsOn(treeOT)

lazy val treeCoreJVM = treeCore.jvm
lazy val treeCoreJS = treeCore.js



  /////////////
 // tree-ot //
/////////////
lazy val treeOT = crossProject(JSPlatform, JVMPlatform).in(file("tree-ot")).
  //Settings for all projects
  settings(
  name := "tree-ot",

  testDeps,
   
  libraryDependencies ++= Seq(
    "org.typelevel"               %%% "cats-free"         % catsVersion,
  ),
).jvmSettings(

).jsSettings(
  //Produce a module, so we can use @JSImport.
  scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
)

lazy val treeOTJVM = treeOT.jvm
lazy val treeOTJS = treeOT.js



  ////////////////
 // tree-react //
////////////////
lazy val treeReact = crossProject(JSPlatform, JVMPlatform).in(file("tree-react")).
  //Settings for all projects
  settings(
  name := "tree-react",
  libraryDependencies += "org.log4s" %%% "log4s" % log4sVersion

 ).jvmSettings(

).jsSettings(
  //Scalajs dependencies that are used on the client only
  resolvers += Resolver.jcenterRepo,
   
  scalajsReactDeps,

  //Produce a module, so we can use @JSImport.
  scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
).dependsOn(treeCore)

lazy val treeReactJVM = treeReact.jvm
lazy val treeReactJS = treeReact.js



  //////////////////
 // electron-app //
//////////////////
lazy val electronApp = crossProject(JSPlatform, JVMPlatform).in(file("electron-app")).
  //Settings for all projects
  settings(
  name := "electron-app",

  addCompilerPlugin(
    "org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.patch
  )
).jvmSettings(

).jsSettings(

//  Alternative approach - output all scalajs and js dependencies to source folder for electron-app project
//  artifactPath below is preferred, since it only moves the non-test files, and omits dependencies, which we don't use.
//  crossTarget in (Compile, fullOptJS) := scalaJsSrcDir,
//  crossTarget in (Compile, fastOptJS) := scalaJsSrcDir,
//  crossTarget in (Compile, packageJSDependencies) := scalaJsSrcDir,

  // Move just the required artifacts to scalajs_src for electron project to use. This allows us to include that
  // directory in the electron app, and include only the minimal required files. Note the baseDirectory for the
  // js project is "js" in the root project directory, hence the "..". 
  artifactPath in (Compile, fastOptJS) := baseDirectory.value / ".." / "scalajs_src" / "fastOpt.js",
  artifactPath in (Compile, fullOptJS) := baseDirectory.value / ".." / "scalajs_src" / "fullOpt.js",

  //Produce a module, so we can use @JSImport.
  scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }

).dependsOn(scalajsElectron, scalajsElectronReact, scalajsReactMaterialUIExtra, treeReact, scalajsReactDocgenFacade)

lazy val electronAppJVM = electronApp.jvm
lazy val electronAppJS = electronApp.js


  //////////////////////
 // sui-electron-app //
//////////////////////
lazy val suiElectronApp = crossProject(JSPlatform, JVMPlatform).in(file("sui-electron-app")).
  //Settings for all projects
  settings(
  name := "sui-electron-app",

  addCompilerPlugin(
    "org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.patch
  )
).jvmSettings(

).jsSettings(

  // Move just the required artifacts to scalajs_src for electron project to use. This allows us to include that
  // directory in the electron app, and include only the minimal required files. Note the baseDirectory for the
  // js project is "js" in the root project directory, hence the "..".
  artifactPath in (Compile, fastOptJS) := baseDirectory.value / ".." / "scalajs_src" / "fastOpt.js",
  artifactPath in (Compile, fullOptJS) := baseDirectory.value / ".." / "scalajs_src" / "fullOpt.js",

  //Produce a module, so we can use @JSImport.
  scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }

).dependsOn(scalajsElectron, scalajsElectronReact, scalajsReactMaterialUIExtra, treeReact, scalajsReactSemanticUI)

lazy val suiElectronAppJVM = suiElectronApp.jvm
lazy val suiElectronAppJS = suiElectronApp.js