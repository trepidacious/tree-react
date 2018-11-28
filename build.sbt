import sbtcrossproject.CrossPlugin.autoImport.crossProject



name := "tree-react root project"
version in ThisBuild := "0.0.1-SNAPSHOT"
organization in ThisBuild := "org.rebeam"
scalaVersion in ThisBuild := "2.12.6"
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


lazy val catsVersion                = "1.2.0"
lazy val catsEffectVersion          = "0.10.1"
lazy val scalajsReactVersion        = "1.2.3"
lazy val circeVersion               = "0.9.3"
lazy val nodejsVersion              = "0.4.2"
lazy val scalacssVersion            = "0.5.3"
lazy val scalatestVersion           = "3.0.5"



lazy val root = project.in(file(".")).
  aggregate(
    scalajsReactMaterialUIJS, scalajsReactMaterialUIJVM,
    scalajsReactMaterialIconsJS, scalajsReactMaterialIconsJVM,
    scalajsReactDownshiftJS, scalajsReactDownshiftJVM, 
    scalajsReactMaterialUIExtraJS, scalajsReactMaterialUIExtraJVM,
    scalajsElectronJS, scalajsElectronJVM,
    scalajsElectronReactJS, scalajsElectronReactJVM,
    scalajsElectronReactAppJS, scalajsElectronReactAppJVM,
    scalajsGoogleDriveJS, scalajsGoogleDriveJVM
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

    libraryDependencies ++= Seq(
      "com.github.japgolly.scalajs-react" %%% "core" % scalajsReactVersion,
      "com.github.japgolly.scalajs-react" %%% "extra" % scalajsReactVersion
    ),
    
    //Produce a module, so we can use @JSImport on material-ui
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
  )

lazy val scalajsReactMaterialUIJVM = scalajsReactMaterialUI.jvm
lazy val scalajsReactMaterialUIJS = scalajsReactMaterialUI.js



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

    libraryDependencies ++= Seq(
      "com.github.japgolly.scalajs-react" %%% "core" % scalajsReactVersion,
      "com.github.japgolly.scalajs-react" %%% "extra" % scalajsReactVersion
    ),
    
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

    //TODO factor this out?
    libraryDependencies ++= Seq(
      "com.github.japgolly.scalajs-react" %%% "core" % scalajsReactVersion,
      "com.github.japgolly.scalajs-react" %%% "extra" % scalajsReactVersion
    ),
    
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

    //TODO factor this out?
    libraryDependencies ++= Seq(
      "com.github.japgolly.scalajs-react" %%% "core" % scalajsReactVersion,
      "com.github.japgolly.scalajs-react" %%% "extra" % scalajsReactVersion,
      "com.github.japgolly.scalacss"      %%% "ext-react" % scalacssVersion
    ),

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



  /////////////////////////////////
 // scalajs-electron-react-app //
////////////////////////////////
val scalaJsSrcDir = file("electron-app/scalajs_src")
lazy val scalajsElectronReactApp = crossProject(JSPlatform, JVMPlatform).in(file("scalajs-electron-react-app")).
  //Settings for all projects
  settings(
    name := "scalajs-electron-react-app"

  ).jvmSettings(

  ).jsSettings(

    //Output scalajs and js dependencies to source folder for electron-app project
    crossTarget in (Compile, fullOptJS) := scalaJsSrcDir,
    crossTarget in (Compile, fastOptJS) := scalaJsSrcDir,
    crossTarget in (Compile, packageJSDependencies) := scalaJsSrcDir,

    //Produce a module, so we can use @JSImport.
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }

  ).dependsOn(scalajsElectron, scalajsElectronReact, scalajsReactMaterialUIExtra)

lazy val scalajsElectronReactAppJVM = scalajsElectronReactApp.jvm
lazy val scalajsElectronReactAppJS = scalajsElectronReactApp.js


//////////////////////
// scalajs-electron //
//////////////////////
lazy val scalajsGoogleDrive = crossProject(JSPlatform, JVMPlatform).in(file("scalajs-google-drive")).
  //Settings for all projects
  settings(
  name := "scalajs-google-drive",

//  libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5",
  libraryDependencies ++= Seq(
    "org.scalatest"               %%% "scalatest"         % scalatestVersion % "test",
    "io.circe"                    %%% "circe-core"        % circeVersion,
    "io.circe"                    %%% "circe-generic"     % circeVersion,
    "io.circe"                    %%% "circe-parser"      % circeVersion,
    "io.circe"                    %%% "circe-generic-extras"      % circeVersion,
    "org.typelevel"               %%% "cats-core"         % catsVersion,
    "org.typelevel"               %%% "cats-effect"       % catsEffectVersion,
  ),

  addCompilerPlugin(
    "org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.patch
  )

).jvmSettings(

).jsSettings(
  //Produce a module, so we can use @JSImport.
  scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
)

lazy val scalajsGoogleDriveJVM = scalajsGoogleDrive.jvm
lazy val scalajsGoogleDriveJS = scalajsGoogleDrive.js
