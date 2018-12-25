
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object SvgIcon {
  
  sealed trait Color{ val value: String }

  object Color {
    case object Secondary extends Color { val value: String = "secondary" }
    case object Primary extends Color { val value: String = "primary" }
    case object Disabled extends Color { val value: String = "disabled" }
    case object Action extends Color { val value: String = "action" }
    case object Error extends Color { val value: String = "error" }
    case object Inherit extends Color { val value: String = "inherit" }
  }
            
  sealed trait FontSize{ val value: String }

  object FontSize {
    case object Inherit extends FontSize { val value: String = "inherit" }
    case object Default extends FontSize { val value: String = "default" }
    case object Small extends FontSize { val value: String = "small" }
    case object Large extends FontSize { val value: String = "large" }
  }
          
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var color: js.UndefOr[String] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var fontSize: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var nativeColor: js.UndefOr[String] = js.native
    var shapeRendering: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var titleAccess: js.UndefOr[String] = js.native
    var viewBox: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/SvgIcon", JSImport.Default)
  @js.native
  object SvgIconJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](SvgIconJS)
  
  /**
   * 
   * @param children
   *        Node passed into the SVG element.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param color
   *        The color of the component. It supports those theme colors that make sense for this component.
   *        You can use the `nativeColor` property to apply a color attribute to the SVG element.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param fontSize
   *        The fontSize applied to the icon. Defaults to 24px, but can be configure to inherit font size.
   * @param key
   *        React key
   * @param nativeColor
   *        Applies a color attribute to the SVG element.
   * @param shapeRendering
   *        The shape-rendering attribute. The behavior of the different options is described
   *        [here](https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute/shape-rendering).
   *        If you are having issues with blurry icons you should investigate this property.
   * @param style
   *        React element CSS style
   * @param titleAccess
   *        Provides a human-readable title for the element that contains it.
   *        https://www.w3.org/TR/SVG-access/#Equivalent
   * @param viewBox
   *        Allows you to redefine what the coordinates without units mean inside an SVG element.
   *        For example, if the SVG element is 500 (width) by 200 (height),
   *        and you pass viewBox="0 0 50 20",
   *        this means that the coordinates inside the SVG will go from the top left corner (0,0)
   *        to bottom right (50,20) and each unit will be worth 10px.
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
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    fontSize: js.UndefOr[FontSize] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    nativeColor: js.UndefOr[String] = js.undefined,
    shapeRendering: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    titleAccess: js.UndefOr[String] = js.undefined,
    viewBox: js.UndefOr[String] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (component.isDefined) {p.component = component}
    if (fontSize.isDefined) {p.fontSize = fontSize.map(v => v.value)}
    if (key.isDefined) {p.key = key}
    if (nativeColor.isDefined) {p.nativeColor = nativeColor}
    if (shapeRendering.isDefined) {p.shapeRendering = shapeRendering}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (titleAccess.isDefined) {p.titleAccess = titleAccess}
    if (viewBox.isDefined) {p.viewBox = viewBox}

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
        