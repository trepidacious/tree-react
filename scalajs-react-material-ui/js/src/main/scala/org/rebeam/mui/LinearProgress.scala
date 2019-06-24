
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object LinearProgress {
  
  sealed trait Color{ val value: String }

  object Color {
    case object Primary extends Color { val value: String = "primary" }
    case object Secondary extends Color { val value: String = "secondary" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Determinate extends Variant { val value: String = "determinate" }
    case object Indeterminate extends Variant { val value: String = "indeterminate" }
    case object Buffer extends Variant { val value: String = "buffer" }
    case object Query extends Variant { val value: String = "query" }
  }
          
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var color: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var value: js.UndefOr[Double] = js.native
    var valueBuffer: js.UndefOr[Double] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/LinearProgress", JSImport.Default)
  @js.native
  object LinearProgressJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.None](LinearProgressJS)
  
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
   * @param key
   *        React key
   * @param style
   *        React element CSS style
   * @param value
   *        The value of the progress indicator for the determinate and buffer variants.
   *        Value between 0 and 100.
   * @param valueBuffer
   *        The value for the buffer variant.
   *        Value between 0 and 100.
   * @param variant
   *        The variant to use.
   *        Use indeterminate or query when there is no progress value.
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
    key: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    value: js.UndefOr[Double] = js.undefined,
    valueBuffer: js.UndefOr[Double] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (key.isDefined) {p.key = key}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (value.isDefined) {p.value = value}
    if (valueBuffer.isDefined) {p.valueBuffer = valueBuffer}
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
        