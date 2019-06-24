
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object GridListTileBar {
  
  sealed trait ActionPosition{ val value: String }

  object ActionPosition {
    case object Left extends ActionPosition { val value: String = "left" }
    case object Right extends ActionPosition { val value: String = "right" }
  }
            
  sealed trait TitlePosition{ val value: String }

  object TitlePosition {
    case object Top extends TitlePosition { val value: String = "top" }
    case object Bottom extends TitlePosition { val value: String = "bottom" }
  }
          
  @js.native
  trait Props extends js.Object {
    var actionIcon: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var actionPosition: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var key: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var subtitle: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var title: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var titlePosition: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/GridListTileBar", JSImport.Default)
  @js.native
  object GridListTileBarJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.None](GridListTileBarJS)
  
  /**
   * 
   * @param actionIcon
   *        An IconButton element to be used as secondary action target
   *        (primary action target is the tile itself).
   * @param actionPosition
   *        Position of secondary action IconButton.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param key
   *        React key
   * @param style
   *        React element CSS style
   * @param subtitle
   *        String or element serving as subtitle (support text).
   * @param title
   *        Title to be displayed on tile.
   * @param titlePosition
   *        Position of the title bar.
   * @param additionalProps
   *        Optional parameter - if specified, this must be a js.Object containing additional props
   *        to pass to the underlying JS component. Each field of additionalProps will be added to the
   *        JS props object, if a field with the same name is not already present (from one of the other
   *        parameters of this function). This functions like `...additionalProps` at the beginning of the
   *        component in JS. Used for e.g. Downshift integration, where Downshift will provide properties
   *        in this format to be added to rendered components.
   *        Since this is untyped, use with care - e.g. make sure props are in the correct format for JS components
   */
  def apply(
    actionIcon: js.UndefOr[VdomNode] = js.undefined,
    actionPosition: js.UndefOr[ActionPosition] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    subtitle: js.UndefOr[VdomNode] = js.undefined,
    title: js.UndefOr[VdomNode] = js.undefined,
    titlePosition: js.UndefOr[TitlePosition] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (actionIcon.isDefined) {p.actionIcon = actionIcon.map(v => v.rawNode)}
    if (actionPosition.isDefined) {p.actionPosition = actionPosition.map(v => v.value)}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (key.isDefined) {p.key = key}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (subtitle.isDefined) {p.subtitle = subtitle.map(v => v.rawNode)}
    if (title.isDefined) {p.title = title.map(v => v.rawNode)}
    if (titlePosition.isDefined) {p.titlePosition = titlePosition.map(v => v.value)}

    additionalProps.foreach {
      a => {
        val dict = a.asInstanceOf[js.Dictionary[js.Any]]
        val pDict = p.asInstanceOf[js.Dictionary[js.Any]]
        for ((prop, value) <- dict) {
          if (!p.hasOwnProperty(prop)) pDict(prop) = value
        }
      }
    }
    
    jsComponent(p)
  }

}
        