
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object ButtonOr {
  
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var text: js.UndefOr[js.Any] = js.native
  }

  @JSImport("semantic-ui-react", "ButtonOr")
  @js.native
  object ButtonOrJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](ButtonOrJS)
  
  /**
   * Button groups can contain conditionals.
   * @param as
   *        An element type to render as (string or function).
   * @param className
   *        Additional classes.
   * @param key
   *        React key
   * @param style
   *        React element CSS style
   * @param text
   *        Or buttons can have their text localized, or adjusted by using the text prop.
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
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    text: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (key.isDefined) {p.key = key}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (text.isDefined) {p.text = text}

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
        