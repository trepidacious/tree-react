package org.rebeam.electron.react

import CssSettings._

import scala.language.postfixOps

object Styles extends StyleSheet.Inline {
  import dsl._

  // TODO pull request to add this to scalacss?
  private val appRegionDrag = scalacss.internal.Attr.real("-webkit-app-region") := "drag"
  private val appRegionNoDrag = scalacss.internal.Attr.real("-webkit-app-region") := "no-drag"

  val titlebar: StyleA = style(
    backgroundColor(c"#2e3b84"),
    color(c"#2e3b84"),
    appRegionDrag,
    height(28 px),
    width(100 %%),
    flexGrow(0),
    flexShrink(0),
    display.flex,
    flexDirection.row
//    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", "Roboto", "Oxygen", "Ubuntu", "Cantarell", "Fira Sans", "Droid Sans", "Helvetica Neue", Arial, sans-serif;
//    font-size: 12px;
//    border-bottom: 1px solid #000;
  )

  val resizeHandle: StyleA = style(
    position.absolute,
    top(0 px),
    left(0 px),
    appRegionNoDrag
  )

  val resizeHandleLeft: StyleA = style(
    width(3 px),
    height(28 px)
  )

  val resizeHandleTop: StyleA = style(
    width(100 %%),
    height(3 px)
  )

  val icon: StyleA = style(
    height(16 px),
    width(16 px),
    margin(6 px)
  )

}
