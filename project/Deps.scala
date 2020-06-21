import sbt._
import Keys._
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Deps {

  lazy val catsVersion                = "2.1.1"
  lazy val catsEffectVersion          = "2.1.2"
  lazy val circeVersion               = "0.13.0"
  // lazy val nodejsVersion              = "0.4.2"
  // lazy val scalacssVersion            = "0.5.3"
  lazy val shapelessVersion           = "2.3.3"
  lazy val monocleVersion             = "2.0.4"
  lazy val scalacticVersion           = "3.1.1" // Needed?
  lazy val scalatestVersion           = "3.1.1"
  lazy val scalatestPlusScalacheckVersion           = "3.1.1.1"
  lazy val scalacheckVersion          = "1.14.3"
  lazy val kindProjectorVersion       = "0.11.0"
  lazy val slinkyVersion              = "0.6.5"
  lazy val scribeVersion              = "2.7.12"

  lazy val kindProjector = 
    addCompilerPlugin("org.typelevel" %% "kind-projector" % kindProjectorVersion cross CrossVersion.full)

  lazy val test = Seq(
    libraryDependencies ++= Seq(
      "org.scalactic"               %%% "scalactic"         % scalacticVersion                  % "test",
      "org.scalatest"               %%% "scalatest"         % scalatestVersion                  % "test",
      "org.scalatestplus"           %%% "scalacheck-1-14"   % scalatestPlusScalacheckVersion    % "test",      // See https://github.com/scalatest/scalatestplus-scalacheck/issues/28
      "org.scalacheck"              %%% "scalacheck"        % scalacheckVersion                 % "test"
    )
  )

  lazy val slinky = Seq(
    libraryDependencies ++= Seq(
      "me.shadaj"                   %%% "slinky-core"                   % slinkyVersion, // core React functionality, no React DOM
      "me.shadaj"                   %%% "slinky-web"                    % slinkyVersion, // React DOM, HTML and SVG tags
  //    "me.shadaj"                   %%% "slinky-native"                 % slinkyVersion, // React Native components
  //    "me.shadaj"                   %%% "slinky-hot"                    % slinkyVersion, // Hot loading, requires react-proxy package
  //    "me.shadaj"                   %%% "slinky-scalajsreact-interop"   % slinkyVersion, // Interop with japgolly/scalajs-react
    )
  )

  lazy val logging = Seq(
    libraryDependencies ++= Seq(
      "com.outr" %%% "scribe" % scribeVersion
    )
  )

  lazy val circe = Seq(
    libraryDependencies ++= Seq(
      "io.circe"                    %%% "circe-core"        % circeVersion,
      "io.circe"                    %%% "circe-generic"     % circeVersion,
      "io.circe"                    %%% "circe-parser"      % circeVersion,
    )
  )

  lazy val cats = Seq(
    libraryDependencies ++= Seq(
      "org.typelevel"               %%% "cats-core"         % catsVersion,
      "org.typelevel"               %%% "alleycats-core"         % catsVersion,
    )
  )

  lazy val shapeless = Seq(
    libraryDependencies ++= Seq(
      "com.chuusai"                 %%% "shapeless"         % shapelessVersion,
    )
  )

  lazy val monocle = Seq(
    libraryDependencies ++= Seq(
      "com.github.julien-truffaut"  %%% "monocle-core"      % monocleVersion,
      "com.github.julien-truffaut"  %%% "monocle-generic"   % monocleVersion,
      "com.github.julien-truffaut"  %%% "monocle-macro"     % monocleVersion,
      "com.github.julien-truffaut"  %%% "monocle-state"     % monocleVersion,
      "com.github.julien-truffaut"  %%% "monocle-refined"   % monocleVersion,
      "com.github.julien-truffaut"  %%% "monocle-law"       % monocleVersion      % "test",
    )
  )
}