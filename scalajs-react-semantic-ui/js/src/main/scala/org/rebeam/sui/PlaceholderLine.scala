
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object PlaceholderLine {
  
  sealed trait Length{ val value: String }

  object Length {
    case object Short extends Length { val value: String = "short" }
    case object Long extends Length { val value: String = "long" }
    case object Medium extends Length { val value: String = "medium" }
    case object VeryShort extends Length { val value: String = "very short" }
    case object VeryLong extends Length { val value: String = "very long" }
    case object Full extends Length { val value: String = "full" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var length: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "PlaceholderLine")
  @js.native
  object PlaceholderLineJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](PlaceholderLineJS)
  
  /**
   * A placeholder can contain have lines of text.
   * @param as
   *        An element type to render as (string or function).
   * @param className
   *        Additional classes.
   * @param key
   *        React key
   * @param length
   *        A line can specify how long its contents should appear.
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
    as: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    length: js.UndefOr[Length] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (key.isDefined) {p.key = key}
    if (length.isDefined) {p.length = length.map(v => v.value)}
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
    
    jsComponent(p)
  }

}
        