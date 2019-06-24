
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object FormGroup {
  
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var key: js.UndefOr[String] = js.native
    var row: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/FormGroup", JSImport.Default)
  @js.native
  object FormGroupJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](FormGroupJS)
  
  /**
   * `FormGroup` wraps controls such as `Checkbox` and `Switch`.
   * It provides compact row layout.
   * For the `Radio`, you should be using the `RadioGroup` component instead of this one.
   * @param children
   *        The content of the component.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param key
   *        React key
   * @param row
   *        Display group of elements in a compact row.
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
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    row: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (key.isDefined) {p.key = key}
    if (row.isDefined) {p.row = row}
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
    
    jsComponent(p)(children: _*)
  }

}
        