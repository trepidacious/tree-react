
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object CircularProgress {
  
  sealed trait Color{ val value: String }

  object Color {
    case object Primary extends Color { val value: String = "primary" }
    case object Secondary extends Color { val value: String = "secondary" }
    case object Inherit extends Color { val value: String = "inherit" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Determinate extends Variant { val value: String = "determinate" }
    case object Indeterminate extends Variant { val value: String = "indeterminate" }
    case object Static extends Variant { val value: String = "static" }
  }
          
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var color: js.UndefOr[String] = js.native
    var disableShrink: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var size: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var thickness: js.UndefOr[Double] = js.native
    var value: js.UndefOr[Double] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/CircularProgress", JSImport.Default)
  @js.native
  object CircularProgressJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.None](CircularProgressJS)
  
  /**
   * ## ARIA
   * 
   * If the progress bar is describing the loading progress of a particular region of a page,
   * you should use `aria-describedby` to point to the progress bar, and set the `aria-busy`
   * attribute to `true` on that region until it has finished loading.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param color
   *        The color of the component. It supports those theme colors that make sense for this component.
   * @param disableShrink
   *        If `true`, the shrink animation is disabled.
   *        This only works if variant is `indeterminate`.
   * @param key
   *        React key
   * @param size
   *        The size of the circle.
   * @param style
   *        Property spread to root element
   * @param thickness
   *        The thickness of the circle.
   * @param value
   *        The value of the progress indicator for the determinate and static variants.
   *        Value between 0 and 100.
   * @param variant
   *        The variant to use.
   *        Use indeterminate when there is no progress value.
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
    disableShrink: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    size: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    thickness: js.UndefOr[Double] = js.undefined,
    value: js.UndefOr[Double] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (disableShrink.isDefined) {p.disableShrink = disableShrink}
    if (key.isDefined) {p.key = key}
    if (size.isDefined) {p.size = size}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (thickness.isDefined) {p.thickness = thickness}
    if (value.isDefined) {p.value = value}
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
        