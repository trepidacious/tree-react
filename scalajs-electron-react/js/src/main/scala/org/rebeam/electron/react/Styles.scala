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
    color(c"#fff"),
    appRegionDrag,
    width(100 %%),
    flexGrow(0),
    flexShrink(0),
    display.flex,
    flexDirection.row,
    userSelect := "none",
    cursor.default
  )

  val titlebarWindows: StyleA = style(
    titlebar,
    height(28 px),
  )

  val titlebarOSX: StyleA = style(
    titlebar,
    height(22 px)
  )

  val titleColor = color(c"#fff")

  val title: StyleA = style (
    padding(3 px),
    titleColor
  )

//  val appleSystem = fontFace("-apple-system")(_.src("local(-apple-system)"))

  val titleOSX: StyleA = style (
    padding(3 px),
    fontSize(12 px),
    width(100 %%),
    textAlign.center,
    //    fontFamily(appleSystem),
    titleColor
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

  val titleBarPaddingOSX: StyleA = style(
    height(22 px),
    width(80 px),
  )

  val windowControlsButtonSVG: StyleA = style(
    // Inherit fill color from color of parent
    svgFill := "currentColor",
    width(10 px),
    height(10 px)
  )

  val windowControls: StyleA = style(
    flexGrow(0),
    flexShrink(0),
    marginLeft.auto,
    height(100 %%)
  )

  val windowControlsButtonBase: StyleA = style(
    appRegionNoDrag,
    display.inlineBlock,
    position.relative,
    width(45 px),
    height(100 %%),
    padding.`0`,
    margin.`0`,
    overflow.hidden,
    border.none,
    boxShadow := "none",
    borderRadius(0 px),
    titleColor,
    backgroundColor.transparent,
    transition := "background-color 0.25s ease",
    outline.none,
  )

  val windowControlsButtonPlain: StyleA = style(
    windowControlsButtonBase,
    &.hover(
      backgroundColor(rgba(136, 136, 136, 0.4)),
      color(c"#fff")
    ),

    &.hover.active(
      backgroundColor(rgba(102, 102, 102, 0.4)),
      transition := "none"
    )
  )

  val windowControlsButtonClose: StyleA = style(
    windowControlsButtonBase,
    &.hover(
      backgroundColor(rgb(232, 17, 35)),
      color(c"#fff")
    ),

    &.hover.active(
      backgroundColor(rgb(191, 15, 29)),
      transition := "none"
    )
  )

}
