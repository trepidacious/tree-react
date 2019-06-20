
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object InputAdornment {
  
  sealed trait Position{ val value: String }

  object Position {
    case object Start extends Position { val value: String = "start" }
    case object End extends Position { val value: String = "end" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Standard extends Variant { val value: String = "standard" }
    case object Outlined extends Variant { val value: String = "outlined" }
    case object Filled extends Variant { val value: String = "filled" }
  }
          
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var disableTypography: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var position: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/InputAdornment", JSImport.Default)
  @js.native
  object InputAdornmentJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](InputAdornmentJS)
  
  /**
   * 
   * @param children
   *        The content of the component, normally an `IconButton` or string.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param disableTypography
   *        If children is a string then disable wrapping in a Typography component.
   * @param key
   *        React key
   * @param position
   *        The position this adornment should appear relative to the `Input`.
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
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    disableTypography: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    position: js.UndefOr[Position] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (disableTypography.isDefined) {p.disableTypography = disableTypography}
    if (key.isDefined) {p.key = key}
    if (position.isDefined) {p.position = position.map(v => v.value)}
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
    
    jsComponent(p)(children: _*)
  }

}
        