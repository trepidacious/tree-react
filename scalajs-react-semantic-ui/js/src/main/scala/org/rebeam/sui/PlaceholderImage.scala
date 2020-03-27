
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

// import japgolly.scalajs.react.vdom.html_<^._

object PlaceholderImage {
  
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var rectangular: js.UndefOr[js.Any] = js.native
    var square: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "PlaceholderImage")
  @js.native
  object PlaceholderImageJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](PlaceholderImageJS)
  
  /**
   * A placeholder can contain an image.
   * @param as
   *        An element type to render as (string or function).
   * @param className
   *        Additional classes.
   * @param key
   *        React key
   * @param rectangular
   *        An image can modify size correctly with responsive styles.
   * @param square
   *        An image can modify size correctly with responsive styles.
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
    rectangular: js.UndefOr[js.Any] = js.undefined,
    square: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (key.isDefined) {p.key = key}
    if (rectangular.isDefined) {p.rectangular = rectangular}
    if (square.isDefined) {p.square = square}
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
        