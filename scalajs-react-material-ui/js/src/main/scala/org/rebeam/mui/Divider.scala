
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

// import japgolly.scalajs.react.vdom.html_<^._

object Divider {
  
  sealed trait Variant{ val value: String }

  object Variant {
    case object FullWidth extends Variant { val value: String = "fullWidth" }
    case object Inset extends Variant { val value: String = "inset" }
    case object Middle extends Variant { val value: String = "middle" }
  }
          
  @js.native
  trait Props extends js.Object {
    var absolute: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var inset: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var light: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/Divider", JSImport.Default)
  @js.native
  object DividerJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.None](DividerJS)
  
  /**
   * 
   * @param absolute
   *        Absolutely position the element.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param inset
   *        If `true`, the divider will be indented.
   *        __WARNING__: `inset` is deprecated.
   *        Instead use `variant="inset"`.
   * @param key
   *        React key
   * @param light
   *        If `true`, the divider will have a lighter color.
   * @param style
   *        React element CSS style
   * @param variant
   *        The variant to use.
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
    absolute: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    inset: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    light: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (absolute.isDefined) {p.absolute = absolute}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (inset.isDefined) {p.inset = inset}
    if (key.isDefined) {p.key = key}
    if (light.isDefined) {p.light = light}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (variant.isDefined) {p.variant = variant.map(v => v.value)}

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
        