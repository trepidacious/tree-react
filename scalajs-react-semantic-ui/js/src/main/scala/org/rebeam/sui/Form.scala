
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Form {
  
  sealed trait Size{ val value: String }

  object Size {
    case object Mini extends Size { val value: String = "mini" }
    case object Tiny extends Size { val value: String = "tiny" }
    case object Massive extends Size { val value: String = "massive" }
    case object Small extends Size { val value: String = "small" }
    case object Big extends Size { val value: String = "big" }
    case object Huge extends Size { val value: String = "huge" }
    case object Large extends Size { val value: String = "large" }
  }
            
  sealed trait Widths{ val value: String }

  object Widths {
    case object Equal extends Widths { val value: String = "equal" }
  }
          
  @js.native
  trait Props extends js.Object {
    var action: js.UndefOr[String] = js.native
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var error: js.UndefOr[Boolean] = js.native
    var inverted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var loading: js.UndefOr[Boolean] = js.native
    var onSubmit: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var reply: js.UndefOr[Boolean] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var success: js.UndefOr[Boolean] = js.native
    var unstackable: js.UndefOr[Boolean] = js.native
    var warning: js.UndefOr[Boolean] = js.native
    var widths: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "Form")
  @js.native
  object FormJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](FormJS)
  
  /**
   * A Form displays a set of related user input fields in a structured way.
   * @see Button
   * @see Checkbox
   * @see Dropdown
   * @see Input
   * @see Message
   * @see Radio
   * @see Select
   * @see Visibility
   * @param action
   *        The HTML form action
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param error
   *        Automatically show any error Message children.
   * @param inverted
   *        A form can have its color inverted for contrast.
   * @param key
   *        React key
   * @param loading
   *        Automatically show a loading indicator.
   * @param onSubmit
   *        The HTML form submit handler.
   * @param reply
   *        A comment can contain a form to reply to a comment. This may have arbitrary content.
   * @param size
   *        A form can vary in size.
   * @param style
   *        React element CSS style
   * @param success
   *        Automatically show any success Message children.
   * @param unstackable
   *        A form can prevent itself from stacking on mobile.
   * @param warning
   *        Automatically show any warning Message children.
   * @param widths
   *        Forms can automatically divide fields to be equal width.
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
    action: js.UndefOr[String] = js.undefined,
    as: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    loading: js.UndefOr[Boolean] = js.undefined,
    onSubmit: js.UndefOr[Callback] = js.undefined,
    reply: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    success: js.UndefOr[Boolean] = js.undefined,
    unstackable: js.UndefOr[Boolean] = js.undefined,
    warning: js.UndefOr[Boolean] = js.undefined,
    widths: js.UndefOr[Widths] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (action.isDefined) {p.action = action}
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (error.isDefined) {p.error = error}
    if (inverted.isDefined) {p.inverted = inverted}
    if (key.isDefined) {p.key = key}
    if (loading.isDefined) {p.loading = loading}
    if (onSubmit.isDefined) {p.onSubmit = onSubmit.map(v => v.toJsFn)}
    if (reply.isDefined) {p.reply = reply}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (success.isDefined) {p.success = success}
    if (unstackable.isDefined) {p.unstackable = unstackable}
    if (warning.isDefined) {p.warning = warning}
    if (widths.isDefined) {p.widths = widths.map(v => v.value)}

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
        