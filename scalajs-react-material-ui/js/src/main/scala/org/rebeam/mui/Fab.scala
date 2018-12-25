
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Fab {
  
  sealed trait Color{ val value: String }

  object Color {
    case object Default extends Color { val value: String = "default" }
    case object Inherit extends Color { val value: String = "inherit" }
    case object Primary extends Color { val value: String = "primary" }
    case object Secondary extends Color { val value: String = "secondary" }
  }
            
  sealed trait Size{ val value: String }

  object Size {
    case object Small extends Size { val value: String = "small" }
    case object Medium extends Size { val value: String = "medium" }
    case object Large extends Size { val value: String = "large" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Round extends Variant { val value: String = "round" }
    case object Extended extends Variant { val value: String = "extended" }
  }
          
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var color: js.UndefOr[String] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var disableFocusRipple: js.UndefOr[Boolean] = js.native
    var disableRipple: js.UndefOr[Boolean] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var focusVisibleClassName: js.UndefOr[String] = js.native
    var href: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var `type`: js.UndefOr[String] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/Fab", JSImport.Default)
  @js.native
  object FabJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](FabJS)
  
  /**
   * 
   * @param children
   *        The content of the button.
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
   * @param disableFocusRipple
   *        If `true`, the  keyboard focus ripple will be disabled.
   *        `disableRipple` must also be true.
   * @param disableRipple
   *        If `true`, the ripple effect will be disabled.
   * @param disabled
   *        If `true`, the button will be disabled.
   * @param focusVisibleClassName
   *        Property spread to root element
   * @param href
   *        The URL to link to when the button is clicked.
   *        If defined, an `a` element will be used as the root node.
   * @param key
   *        React key
   * @param size
   *        The size of the button.
   *        `small` is equivalent to the dense button styling.
   * @param style
   *        React element CSS style
   * @param `type`
   *        Property spread to root element
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
    color: js.UndefOr[Color] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    disableFocusRipple: js.UndefOr[Boolean] = js.undefined,
    disableRipple: js.UndefOr[Boolean] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    focusVisibleClassName: js.UndefOr[String] = js.undefined,
    href: js.UndefOr[String] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    `type`: js.UndefOr[String] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (component.isDefined) {p.component = component}
    if (disableFocusRipple.isDefined) {p.disableFocusRipple = disableFocusRipple}
    if (disableRipple.isDefined) {p.disableRipple = disableRipple}
    if (disabled.isDefined) {p.disabled = disabled}
    if (focusVisibleClassName.isDefined) {p.focusVisibleClassName = focusVisibleClassName}
    if (href.isDefined) {p.href = href}
    if (key.isDefined) {p.key = key}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (`type`.isDefined) {p.`type` = `type`}
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
        