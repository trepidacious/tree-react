
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object FormField {
  
  sealed trait Width{ val value: String }

  object Width {
    case object Seven extends Width { val value: String = "seven" }
    case object _13 extends Width { val value: String = "13" }
    case object Two extends Width { val value: String = "two" }
    case object _1 extends Width { val value: String = "1" }
    case object Six extends Width { val value: String = "six" }
    case object Sixteen extends Width { val value: String = "sixteen" }
    case object Four extends Width { val value: String = "four" }
    case object _3 extends Width { val value: String = "3" }
    case object _6 extends Width { val value: String = "6" }
    case object _15 extends Width { val value: String = "15" }
    case object Eleven extends Width { val value: String = "eleven" }
    case object Twelve extends Width { val value: String = "twelve" }
    case object _12 extends Width { val value: String = "12" }
    case object One extends Width { val value: String = "one" }
    case object Thirteen extends Width { val value: String = "thirteen" }
    case object _7 extends Width { val value: String = "7" }
    case object _9 extends Width { val value: String = "9" }
    case object _4 extends Width { val value: String = "4" }
    case object Nine extends Width { val value: String = "nine" }
    case object _10 extends Width { val value: String = "10" }
    case object _14 extends Width { val value: String = "14" }
    case object _11 extends Width { val value: String = "11" }
    case object Five extends Width { val value: String = "five" }
    case object Fourteen extends Width { val value: String = "fourteen" }
    case object Eight extends Width { val value: String = "eight" }
    case object _2 extends Width { val value: String = "2" }
    case object _8 extends Width { val value: String = "8" }
    case object _16 extends Width { val value: String = "16" }
    case object Ten extends Width { val value: String = "ten" }
    case object Three extends Width { val value: String = "three" }
    case object Fifteen extends Width { val value: String = "fifteen" }
    case object _5 extends Width { val value: String = "5" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var control: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var error: js.UndefOr[Boolean] = js.native
    var inline: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var label: js.UndefOr[js.Any] = js.native
    var required: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var `type`: js.UndefOr[js.Any] = js.native
    var width: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "FormField")
  @js.native
  object FormFieldJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](FormFieldJS)
  
  /**
   * A field is a form element containing a label and an input.
   * @see Form
   * @see Button
   * @see Checkbox
   * @see Dropdown
   * @see Input
   * @see Radio
   * @see Select
   * @see Visibility
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param control
   *        A form control component (i.e. Dropdown) or HTML tagName (i.e. 'input').
   *        Extra FormField props are passed to the control component.
   *        Mutually exclusive with children.
   * @param disabled
   *        Individual fields may be disabled.
   * @param error
   *        Individual fields may display an error state.
   * @param inline
   *        A field can have its label next to instead of above it.
   * @param key
   *        React key
   * @param label
   *        Mutually exclusive with children.
   * @param required
   *        A field can show that input is mandatory.
   * @param style
   *        React element CSS style
   * @param `type`
   *        Passed to the control component (i.e. &lt;input type='password' /&gt;)
   * @param width
   *        A field can specify its width in grid columns
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
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    control: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    inline: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[js.Any] = js.undefined,
    required: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    `type`: js.UndefOr[js.Any] = js.undefined,
    width: js.UndefOr[Width] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (control.isDefined) {p.control = control}
    if (disabled.isDefined) {p.disabled = disabled}
    if (error.isDefined) {p.error = error}
    if (inline.isDefined) {p.inline = inline}
    if (key.isDefined) {p.key = key}
    if (label.isDefined) {p.label = label}
    if (required.isDefined) {p.required = required}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (`type`.isDefined) {p.`type` = `type`}
    if (width.isDefined) {p.width = width.map(v => v.value)}

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
        