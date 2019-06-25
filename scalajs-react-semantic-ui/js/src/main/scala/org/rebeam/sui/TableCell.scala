
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object TableCell {
  
  sealed trait TextAlign{ val value: String }

  object TextAlign {
    case object Left extends TextAlign { val value: String = "left" }
    case object Center extends TextAlign { val value: String = "center" }
    case object Right extends TextAlign { val value: String = "right" }
  }
            
  sealed trait VerticalAlign{ val value: String }

  object VerticalAlign {
    case object Bottom extends VerticalAlign { val value: String = "bottom" }
    case object Middle extends VerticalAlign { val value: String = "middle" }
    case object Top extends VerticalAlign { val value: String = "top" }
  }
            
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
    var active: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var collapsing: js.UndefOr[Boolean] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var error: js.UndefOr[Boolean] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var negative: js.UndefOr[Boolean] = js.native
    var positive: js.UndefOr[Boolean] = js.native
    var selectable: js.UndefOr[Boolean] = js.native
    var singleLine: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var textAlign: js.UndefOr[String] = js.native
    var verticalAlign: js.UndefOr[String] = js.native
    var warning: js.UndefOr[Boolean] = js.native
    var width: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "TableCell")
  @js.native
  object TableCellJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](TableCellJS)
  
  /**
   * A table row can have cells.
   * @param active
   *        A cell can be active or selected by a user.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param collapsing
   *        A cell can be collapsing so that it only uses as much space as required.
   * @param content
   *        Shorthand for primary content.
   * @param disabled
   *        A cell can be disabled.
   * @param error
   *        A cell may call attention to an error or a negative value.
   * @param icon
   *        Add an Icon by name, props object, or pass an &lt;Icon /&gt;
   * @param key
   *        React key
   * @param negative
   *        A cell may let a user know whether a value is bad.
   * @param positive
   *        A cell may let a user know whether a value is good.
   * @param selectable
   *        A cell can be selectable.
   * @param singleLine
   *        A cell can specify that its contents should remain on a single line and not wrap.
   * @param style
   *        React element CSS style
   * @param textAlign
   *        A table cell can adjust its text alignment.
   * @param verticalAlign
   *        A table cell can adjust its text alignment.
   * @param warning
   *        A cell may warn a user.
   * @param width
   *        A table can specify the width of individual columns independently.
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
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    collapsing: js.UndefOr[Boolean] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    negative: js.UndefOr[Boolean] = js.undefined,
    positive: js.UndefOr[Boolean] = js.undefined,
    selectable: js.UndefOr[Boolean] = js.undefined,
    singleLine: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    textAlign: js.UndefOr[TextAlign] = js.undefined,
    verticalAlign: js.UndefOr[VerticalAlign] = js.undefined,
    warning: js.UndefOr[Boolean] = js.undefined,
    width: js.UndefOr[Width] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (collapsing.isDefined) {p.collapsing = collapsing}
    if (content.isDefined) {p.content = content}
    if (disabled.isDefined) {p.disabled = disabled}
    if (error.isDefined) {p.error = error}
    if (icon.isDefined) {p.icon = icon}
    if (key.isDefined) {p.key = key}
    if (negative.isDefined) {p.negative = negative}
    if (positive.isDefined) {p.positive = positive}
    if (selectable.isDefined) {p.selectable = selectable}
    if (singleLine.isDefined) {p.singleLine = singleLine}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (textAlign.isDefined) {p.textAlign = textAlign.map(v => v.value)}
    if (verticalAlign.isDefined) {p.verticalAlign = verticalAlign.map(v => v.value)}
    if (warning.isDefined) {p.warning = warning}
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
        