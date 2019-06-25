
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Message {
  
  sealed trait Color{ val value: String }

  object Color {
    case object Grey extends Color { val value: String = "grey" }
    case object Teal extends Color { val value: String = "teal" }
    case object Black extends Color { val value: String = "black" }
    case object Purple extends Color { val value: String = "purple" }
    case object Violet extends Color { val value: String = "violet" }
    case object Green extends Color { val value: String = "green" }
    case object Orange extends Color { val value: String = "orange" }
    case object Yellow extends Color { val value: String = "yellow" }
    case object Olive extends Color { val value: String = "olive" }
    case object Red extends Color { val value: String = "red" }
    case object Brown extends Color { val value: String = "brown" }
    case object Blue extends Color { val value: String = "blue" }
    case object Pink extends Color { val value: String = "pink" }
  }
            
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
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var attached: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var color: js.UndefOr[String] = js.native
    var compact: js.UndefOr[Boolean] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var error: js.UndefOr[Boolean] = js.native
    var floating: js.UndefOr[Boolean] = js.native
    var header: js.UndefOr[js.Any] = js.native
    var hidden: js.UndefOr[Boolean] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var info: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var list: js.UndefOr[js.Any] = js.native
    var negative: js.UndefOr[Boolean] = js.native
    var onDismiss: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var positive: js.UndefOr[Boolean] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var success: js.UndefOr[Boolean] = js.native
    var visible: js.UndefOr[Boolean] = js.native
    var warning: js.UndefOr[Boolean] = js.native
  }

  @JSImport("semantic-ui-react", "Message")
  @js.native
  object MessageJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](MessageJS)
  
  /**
   * A message displays information that explains nearby content.
   * @see Form
   * @param as
   *        An element type to render as (string or function).
   * @param attached
   *        A message can be formatted to attach itself to other content.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param color
   *        A message can be formatted to be different colors.
   * @param compact
   *        A message can only take up the width of its content.
   * @param content
   *        Shorthand for primary content.
   * @param error
   *        A message may be formatted to display a negative message. Same as `negative`.
   * @param floating
   *        A message can float above content that it is related to.
   * @param header
   *        Shorthand for MessageHeader.
   * @param hidden
   *        A message can be hidden.
   * @param icon
   *        A message can contain an icon.
   * @param info
   *        A message may be formatted to display information.
   * @param key
   *        React key
   * @param list
   *        Array shorthand items for the MessageList. Mutually exclusive with children.
   * @param negative
   *        A message may be formatted to display a negative message. Same as `error`.
   * @param onDismiss
   *        A message that the user can choose to hide.
   *        Called when the user clicks the "x" icon. This also adds the "x" icon.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param positive
   *        A message may be formatted to display a positive message.  Same as `success`.
   * @param size
   *        A message can have different sizes.
   * @param style
   *        React element CSS style
   * @param success
   *        A message may be formatted to display a positive message.  Same as `positive`.
   * @param visible
   *        A message can be set to visible to force itself to be shown.
   * @param warning
   *        A message may be formatted to display warning messages.
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
    attached: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    compact: js.UndefOr[Boolean] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    floating: js.UndefOr[Boolean] = js.undefined,
    header: js.UndefOr[js.Any] = js.undefined,
    hidden: js.UndefOr[Boolean] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    info: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    list: js.UndefOr[js.Any] = js.undefined,
    negative: js.UndefOr[Boolean] = js.undefined,
    onDismiss: js.UndefOr[Callback] = js.undefined,
    positive: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    success: js.UndefOr[Boolean] = js.undefined,
    visible: js.UndefOr[Boolean] = js.undefined,
    warning: js.UndefOr[Boolean] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (attached.isDefined) {p.attached = attached}
    if (className.isDefined) {p.className = className}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (compact.isDefined) {p.compact = compact}
    if (content.isDefined) {p.content = content}
    if (error.isDefined) {p.error = error}
    if (floating.isDefined) {p.floating = floating}
    if (header.isDefined) {p.header = header}
    if (hidden.isDefined) {p.hidden = hidden}
    if (icon.isDefined) {p.icon = icon}
    if (info.isDefined) {p.info = info}
    if (key.isDefined) {p.key = key}
    if (list.isDefined) {p.list = list}
    if (negative.isDefined) {p.negative = negative}
    if (onDismiss.isDefined) {p.onDismiss = onDismiss.map(v => v.toJsFn)}
    if (positive.isDefined) {p.positive = positive}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (success.isDefined) {p.success = success}
    if (visible.isDefined) {p.visible = visible}
    if (warning.isDefined) {p.warning = warning}

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
        