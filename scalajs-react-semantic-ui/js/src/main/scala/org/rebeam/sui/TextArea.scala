
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object TextArea {
  
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var onChange: js.UndefOr[scalajs.js.Function1[ReactEvent, Unit]] = js.native
    var onInput: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var rows: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var value: js.UndefOr[js.Any] = js.native
  }

  @JSImport("semantic-ui-react", "TextArea")
  @js.native
  object TextAreaJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](TextAreaJS)
  
  /**
   * A TextArea can be used to allow for extended user input.
   * @see Form
   * @param as
   *        An element type to render as (string or function).
   * @param key
   *        React key
   * @param onChange
   *        Called on change.
   *        parameter {SyntheticEvent} event - The React SyntheticEvent object
   *        parameter {object} data - All props and the event value.
   * @param onInput
   *        Called on input.
   *        parameter {SyntheticEvent} event - The React SyntheticEvent object
   *        parameter {object} data - All props and the event value.
   * @param rows
   *        Indicates row count for a TextArea.
   * @param style
   *        React element CSS style
   * @param value
   *        The value of the textarea.
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
    as: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onChange: js.UndefOr[ReactEvent => Callback] = js.undefined,
    onInput: js.UndefOr[Callback] = js.undefined,
    rows: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    value: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (key.isDefined) {p.key = key}
    if (onChange.isDefined) {p.onChange = onChange.map(v => (e: ReactEvent) => v(e).runNow())}
    if (onInput.isDefined) {p.onInput = onInput.map(v => v.toJsFn)}
    if (rows.isDefined) {p.rows = rows}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (value.isDefined) {p.value = value}

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
        