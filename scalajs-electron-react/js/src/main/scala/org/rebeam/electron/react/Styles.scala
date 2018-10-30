package org.rebeam.electron.react

import CssSettings._
import scalacss.internal.ValueT

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

  val titleColor = color(c"#fff")

  val title: StyleA = style (
    padding(3 px),
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

  def windowControlsButton(
    hoverColor: ValueT[ValueT.Color],
    activeColor: ValueT[ValueT.Color]
  ): StyleA = style(
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

    &.hover(
      backgroundColor(hoverColor),
      color(c"#fff")
    ),

    &.hover.active(
      backgroundColor(activeColor),
      transition := "none"
    )
  )

  val windowControlsButtonPlain: StyleA = windowControlsButton(
    rgba(136, 136, 136, 0.4),
    rgba(102, 102, 102, 0.4)
  )

  val windowControlsButtonClose: StyleA = windowControlsButton(
    rgb(232, 17, 35),
    rgb(191, 15, 29)
  )

  //TODO if needed
//  #electron-app-title-bar :not(input):not(textarea), :not(input):not(textarea)::after, :not(input):not(textarea)::before {
//    -webkit-user-select: none;
//    user-select: none;
//    cursor: default;
//  }
}
