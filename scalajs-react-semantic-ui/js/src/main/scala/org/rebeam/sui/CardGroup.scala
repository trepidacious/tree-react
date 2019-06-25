
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object CardGroup {
  
  sealed trait ItemsPerRow{ val value: String }

  object ItemsPerRow {
    case object _4 extends ItemsPerRow { val value: String = "4" }
    case object One extends ItemsPerRow { val value: String = "one" }
    case object Five extends ItemsPerRow { val value: String = "five" }
    case object Ten extends ItemsPerRow { val value: String = "ten" }
    case object _1 extends ItemsPerRow { val value: String = "1" }
    case object _3 extends ItemsPerRow { val value: String = "3" }
    case object _11 extends ItemsPerRow { val value: String = "11" }
    case object _14 extends ItemsPerRow { val value: String = "14" }
    case object Two extends ItemsPerRow { val value: String = "two" }
    case object _12 extends ItemsPerRow { val value: String = "12" }
    case object _7 extends ItemsPerRow { val value: String = "7" }
    case object Four extends ItemsPerRow { val value: String = "four" }
    case object Fifteen extends ItemsPerRow { val value: String = "fifteen" }
    case object _6 extends ItemsPerRow { val value: String = "6" }
    case object Six extends ItemsPerRow { val value: String = "six" }
    case object Sixteen extends ItemsPerRow { val value: String = "sixteen" }
    case object Thirteen extends ItemsPerRow { val value: String = "thirteen" }
    case object _9 extends ItemsPerRow { val value: String = "9" }
    case object _8 extends ItemsPerRow { val value: String = "8" }
    case object _15 extends ItemsPerRow { val value: String = "15" }
    case object Eleven extends ItemsPerRow { val value: String = "eleven" }
    case object _5 extends ItemsPerRow { val value: String = "5" }
    case object _2 extends ItemsPerRow { val value: String = "2" }
    case object _13 extends ItemsPerRow { val value: String = "13" }
    case object Nine extends ItemsPerRow { val value: String = "nine" }
    case object Twelve extends ItemsPerRow { val value: String = "twelve" }
    case object _16 extends ItemsPerRow { val value: String = "16" }
    case object Seven extends ItemsPerRow { val value: String = "seven" }
    case object Fourteen extends ItemsPerRow { val value: String = "fourteen" }
    case object Three extends ItemsPerRow { val value: String = "three" }
    case object _10 extends ItemsPerRow { val value: String = "10" }
    case object Eight extends ItemsPerRow { val value: String = "eight" }
  }
            
  sealed trait TextAlign{ val value: String }

  object TextAlign {
    case object Left extends TextAlign { val value: String = "left" }
    case object Center extends TextAlign { val value: String = "center" }
    case object Right extends TextAlign { val value: String = "right" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var centered: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var doubling: js.UndefOr[Boolean] = js.native
    var items: js.UndefOr[js.Any] = js.native
    var itemsPerRow: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var stackable: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var textAlign: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "CardGroup")
  @js.native
  object CardGroupJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](CardGroupJS)
  
  /**
   * A group of cards.
   * @param as
   *        An element type to render as (string or function).
   * @param centered
   *        A group of cards can center itself inside its container.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param doubling
   *        A group of cards can double its column width for mobile.
   * @param items
   *        Shorthand array of props for Card.
   * @param itemsPerRow
   *        A group of cards can set how many cards should exist in a row.
   * @param key
   *        React key
   * @param stackable
   *        A group of cards can automatically stack rows to a single columns on mobile devices.
   * @param style
   *        React element CSS style
   * @param textAlign
   *        A card group can adjust its text alignment.
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
    centered: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    doubling: js.UndefOr[Boolean] = js.undefined,
    items: js.UndefOr[js.Any] = js.undefined,
    itemsPerRow: js.UndefOr[ItemsPerRow] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    stackable: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    textAlign: js.UndefOr[TextAlign] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (centered.isDefined) {p.centered = centered}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (doubling.isDefined) {p.doubling = doubling}
    if (items.isDefined) {p.items = items}
    if (itemsPerRow.isDefined) {p.itemsPerRow = itemsPerRow.map(v => v.value)}
    if (key.isDefined) {p.key = key}
    if (stackable.isDefined) {p.stackable = stackable}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (textAlign.isDefined) {p.textAlign = textAlign.map(v => v.value)}

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
        