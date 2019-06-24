
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object InputLabel {
  
  sealed trait Margin{ val value: String }

  object Margin {
    case object Dense extends Margin { val value: String = "dense" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Standard extends Variant { val value: String = "standard" }
    case object Outlined extends Variant { val value: String = "outlined" }
    case object Filled extends Variant { val value: String = "filled" }
  }
          
  @js.native
  trait Props extends js.Object {
    var FormLabelClasses: js.UndefOr[js.Object] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var disableAnimation: js.UndefOr[Boolean] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var error: js.UndefOr[Boolean] = js.native
    var filled: js.UndefOr[Boolean] = js.native
    var focused: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var margin: js.UndefOr[String] = js.native
    var muiFormControl: js.UndefOr[js.Object] = js.native
    var required: js.UndefOr[Boolean] = js.native
    var shrink: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/InputLabel", JSImport.Default)
  @js.native
  object InputLabelJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](InputLabelJS)
  
  /**
   * 
   * @param FormLabelClasses
   *        `classes` property applied to the [`FormLabel`](/api/form-label/) element.
   * @param children
   *        The contents of the `InputLabel`.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   *        Passed to FormLabel
   * @param disableAnimation
   *        If `true`, the transition animation is disabled.
   * @param disabled
   *        If `true`, apply disabled class.
   * @param error
   *        If `true`, the label will be displayed in an error state.
   * @param filled
   *        If `true`, the label should use filled classes key.
   *        Passed to FormLabel
   * @param focused
   *        If `true`, the input of this label is focused.
   * @param key
   *        React key
   * @param margin
   *        If `dense`, will adjust vertical spacing. This is normally obtained via context from
   *        FormControl.
   * @param muiFormControl
   *        Property spread to root element
   * @param required
   *        if `true`, the label will indicate that the input is required.
   * @param shrink
   *        If `true`, the label is shrunk.
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
    FormLabelClasses: js.UndefOr[js.Object] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    disableAnimation: js.UndefOr[Boolean] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    filled: js.UndefOr[Boolean] = js.undefined,
    focused: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    margin: js.UndefOr[Margin] = js.undefined,
    muiFormControl: js.UndefOr[js.Object] = js.undefined,
    required: js.UndefOr[Boolean] = js.undefined,
    shrink: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (FormLabelClasses.isDefined) {p.FormLabelClasses = FormLabelClasses}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (disableAnimation.isDefined) {p.disableAnimation = disableAnimation}
    if (disabled.isDefined) {p.disabled = disabled}
    if (error.isDefined) {p.error = error}
    if (filled.isDefined) {p.filled = filled}
    if (focused.isDefined) {p.focused = focused}
    if (key.isDefined) {p.key = key}
    if (margin.isDefined) {p.margin = margin.map(v => v.value)}
    if (muiFormControl.isDefined) {p.muiFormControl = muiFormControl}
    if (required.isDefined) {p.required = required}
    if (shrink.isDefined) {p.shrink = shrink}
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
        