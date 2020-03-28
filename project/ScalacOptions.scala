object ScalacOptions {
  val flags = Seq(
    "-deprecation", // Emit warning and location for usages of deprecated APIs.
    "-encoding", "utf-8", // Specify character encoding used by source files.
    "-explaintypes", // Explain type errors in more detail.
    "-feature", // Emit warning and location for usages of features that should be imported explicitly.
    "-unchecked", // Enable additional warnings where generated code depends on assumptions.

    "-Xfatal-warnings",
    "-Xlint",
    "-Xcheckinit",
    "-Xlint:-unused",
    "-Ywarn-unused:imports",
    "-language:existentials",
    "-language:higherKinds",
    "-Xlint:adapted-args",
    // "-Yno-adapted-args",
    // "-Ywarn-dead-code",  //TODO restore for JVM and shared only
    // "-Ywarn-numeric-widen",
  //  "-Ywarn-value-discard",
    // "-Xfuture",
    //"-Yno-predef"
    "-Ymacro-annotations",
  )
}
