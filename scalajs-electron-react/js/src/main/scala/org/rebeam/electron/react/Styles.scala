package org.rebeam.electron.react

import CssSettings._

import scala.language.postfixOps

object Styles extends StyleSheet.Inline {
  import dsl._

  val titlebar = style(
    backgroundColor(c"#2e3b84"),
    scalacss.internal.Attr.real("-webkit-app-region") := "drag",
    height(22 px),
    width(100 %%)
  )
}
