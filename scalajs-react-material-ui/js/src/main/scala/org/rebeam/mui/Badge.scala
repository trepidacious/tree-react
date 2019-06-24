
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Badge {
  
  sealed trait Color{ val value: String }

  object Color {
    case object Default extends Color { val value: String = "default" }
    case object Primary extends Color { val value: String = "primary" }
    case object Secondary extends Color { val value: String = "secondary" }
    case object Error extends Color { val value: String = "error" }
  }
          
  @js.native
  trait Props extends js.Object {
    var badgeContent: japgolly.scalajs.react.raw.React.Node = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var color: js.UndefOr[String] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var invisible: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/Badge", JSImport.Default)
  @js.native
  object BadgeJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](BadgeJS)
  
  /**
   * 
   * @param badgeContent
   *        The content rendered within the badge.
   * @param children
   *        The badge will be added relative to this node.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param color
   *        The color of the component. It supports those theme colors that make sense for this component.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param invisible
   *        If `true`, the badge will be invisible.
   * @param key
   *        React key
   * @param style
   *        React element CSS style
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
    badgeContent: VdomNode,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    invisible: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    p.badgeContent = badgeContent.rawNode
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (component.isDefined) {p.component = component}
    if (invisible.isDefined) {p.invisible = invisible}
    if (key.isDefined) {p.key = key}
    if (style.isDefined) {p.style = style.map(v => v.o)}

    additionalProps.foreach {
      a => {
        val dict = a.asInstanceOf[js.Dictionary[js.Any]]
        val pDict = p.asInstanceOf[js.Dictionary[js.Any]]
        for ((prop, value) <- dict) {
          if (!p.hasOwnProperty(prop)) pDict(prop) = value
        }
      }
    }
    
    jsComponent(p)(children: _*)
  }

}
        