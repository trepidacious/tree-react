
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object FormGroup {
  
  sealed trait Widths{ val value: String }

  object Widths {
    case object Fourteen extends Widths { val value: String = "fourteen" }
    case object Equal extends Widths { val value: String = "equal" }
    case object Nine extends Widths { val value: String = "nine" }
    case object Six extends Widths { val value: String = "six" }
    case object Fifteen extends Widths { val value: String = "fifteen" }
    case object One extends Widths { val value: String = "one" }
    case object Sixteen extends Widths { val value: String = "sixteen" }
    case object Seven extends Widths { val value: String = "seven" }
    case object _8 extends Widths { val value: String = "8" }
    case object _2 extends Widths { val value: String = "2" }
    case object Five extends Widths { val value: String = "five" }
    case object _12 extends Widths { val value: String = "12" }
    case object _9 extends Widths { val value: String = "9" }
    case object _5 extends Widths { val value: String = "5" }
    case object _6 extends Widths { val value: String = "6" }
    case object Ten extends Widths { val value: String = "ten" }
    case object _16 extends Widths { val value: String = "16" }
    case object _10 extends Widths { val value: String = "10" }
    case object _13 extends Widths { val value: String = "13" }
    case object Twelve extends Widths { val value: String = "twelve" }
    case object Thirteen extends Widths { val value: String = "thirteen" }
    case object Eight extends Widths { val value: String = "eight" }
    case object Eleven extends Widths { val value: String = "eleven" }
    case object _1 extends Widths { val value: String = "1" }
    case object _3 extends Widths { val value: String = "3" }
    case object _14 extends Widths { val value: String = "14" }
    case object _4 extends Widths { val value: String = "4" }
    case object Three extends Widths { val value: String = "three" }
    case object _15 extends Widths { val value: String = "15" }
    case object Four extends Widths { val value: String = "four" }
    case object Two extends Widths { val value: String = "two" }
    case object _11 extends Widths { val value: String = "11" }
    case object _7 extends Widths { val value: String = "7" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var grouped: js.UndefOr[js.Any] = js.native
    var inline: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var unstackable: js.UndefOr[Boolean] = js.native
    var widths: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "FormGroup")
  @js.native
  object FormGroupJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](FormGroupJS)
  
  /**
   * A set of fields can appear grouped together.
   * @see Form
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param grouped
   *        Fields can show related choices.
   * @param inline
   *        Multiple fields may be inline in a row.
   * @param key
   *        React key
   * @param style
   *        React element CSS style
   * @param unstackable
   *        A form group can prevent itself from stacking on mobile.
   * @param widths
   *        Fields Groups can specify their width in grid columns or automatically divide fields to be equal width.
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
    grouped: js.UndefOr[js.Any] = js.undefined,
    inline: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    unstackable: js.UndefOr[Boolean] = js.undefined,
    widths: js.UndefOr[Widths] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (grouped.isDefined) {p.grouped = grouped}
    if (inline.isDefined) {p.inline = inline}
    if (key.isDefined) {p.key = key}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (unstackable.isDefined) {p.unstackable = unstackable}
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
        