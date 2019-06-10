
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Grid {
  
  sealed trait Columns{ val value: String }

  object Columns {
    case object Eight extends Columns { val value: String = "eight" }
    case object _9 extends Columns { val value: String = "9" }
    case object _4 extends Columns { val value: String = "4" }
    case object _13 extends Columns { val value: String = "13" }
    case object _5 extends Columns { val value: String = "5" }
    case object Fourteen extends Columns { val value: String = "fourteen" }
    case object Eleven extends Columns { val value: String = "eleven" }
    case object _1 extends Columns { val value: String = "1" }
    case object _16 extends Columns { val value: String = "16" }
    case object Thirteen extends Columns { val value: String = "thirteen" }
    case object Six extends Columns { val value: String = "six" }
    case object _2 extends Columns { val value: String = "2" }
    case object _14 extends Columns { val value: String = "14" }
    case object Fifteen extends Columns { val value: String = "fifteen" }
    case object Three extends Columns { val value: String = "three" }
    case object Four extends Columns { val value: String = "four" }
    case object Two extends Columns { val value: String = "two" }
    case object _15 extends Columns { val value: String = "15" }
    case object _6 extends Columns { val value: String = "6" }
    case object Seven extends Columns { val value: String = "seven" }
    case object Nine extends Columns { val value: String = "nine" }
    case object One extends Columns { val value: String = "one" }
    case object Five extends Columns { val value: String = "five" }
    case object _8 extends Columns { val value: String = "8" }
    case object _7 extends Columns { val value: String = "7" }
    case object Ten extends Columns { val value: String = "ten" }
    case object _3 extends Columns { val value: String = "3" }
    case object Equal extends Columns { val value: String = "equal" }
    case object Twelve extends Columns { val value: String = "twelve" }
    case object _10 extends Columns { val value: String = "10" }
    case object _12 extends Columns { val value: String = "12" }
    case object Sixteen extends Columns { val value: String = "sixteen" }
    case object _11 extends Columns { val value: String = "11" }
  }
            
  sealed trait TextAlign{ val value: String }

  object TextAlign {
    case object Left extends TextAlign { val value: String = "left" }
    case object Center extends TextAlign { val value: String = "center" }
    case object Right extends TextAlign { val value: String = "right" }
    case object Justified extends TextAlign { val value: String = "justified" }
  }
            
  sealed trait VerticalAlign{ val value: String }

  object VerticalAlign {
    case object Bottom extends VerticalAlign { val value: String = "bottom" }
    case object Middle extends VerticalAlign { val value: String = "middle" }
    case object Top extends VerticalAlign { val value: String = "top" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[js.Any] = js.native
    var celled: js.UndefOr[js.Any] = js.native
    var centered: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var columns: js.UndefOr[String] = js.native
    var container: js.UndefOr[Boolean] = js.native
    var divided: js.UndefOr[js.Any] = js.native
    var doubling: js.UndefOr[Boolean] = js.native
    var inverted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var padded: js.UndefOr[js.Any] = js.native
    var relaxed: js.UndefOr[js.Any] = js.native
    var reversed: js.UndefOr[js.Any] = js.native
    var stackable: js.UndefOr[Boolean] = js.native
    var stretched: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var textAlign: js.UndefOr[String] = js.native
    var verticalAlign: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "Grid")
  @js.native
  object GridJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](GridJS)
  
  /**
   * A grid is used to harmonize negative space in a layout.
   * @param as
   *        An element type to render as (string or function).
   * @param celled
   *        A grid can have rows divided into cells.
   * @param centered
   *        A grid can have its columns centered.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param columns
   *        Represents column count per row in Grid.
   * @param container
   *        A grid can be combined with a container to use the available layout and alignment.
   * @param divided
   *        A grid can have dividers between its columns.
   * @param doubling
   *        A grid can double its column width on tablet and mobile sizes.
   * @param inverted
   *        A grid's colors can be inverted.
   * @param key
   *        React key
   * @param padded
   *        A grid can preserve its vertical and horizontal gutters on first and last columns.
   * @param relaxed
   *        A grid can increase its gutters to allow for more negative space.
   * @param reversed
   *        A grid can specify that its columns should reverse order at different device sizes.
   * @param stackable
   *        A grid can have its columns stack on-top of each other after reaching mobile breakpoints.
   * @param stretched
   *        A grid can stretch its contents to take up the entire grid height.
   * @param style
   *        React element CSS style
   * @param textAlign
   *        A grid can specify its text alignment.
   * @param verticalAlign
   *        A grid can specify its vertical alignment to have all its columns vertically centered.
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
    celled: js.UndefOr[js.Any] = js.undefined,
    centered: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    columns: js.UndefOr[Columns] = js.undefined,
    container: js.UndefOr[Boolean] = js.undefined,
    divided: js.UndefOr[js.Any] = js.undefined,
    doubling: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    padded: js.UndefOr[js.Any] = js.undefined,
    relaxed: js.UndefOr[js.Any] = js.undefined,
    reversed: js.UndefOr[js.Any] = js.undefined,
    stackable: js.UndefOr[Boolean] = js.undefined,
    stretched: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    textAlign: js.UndefOr[TextAlign] = js.undefined,
    verticalAlign: js.UndefOr[VerticalAlign] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (celled.isDefined) {p.celled = celled}
    if (centered.isDefined) {p.centered = centered}
    if (className.isDefined) {p.className = className}
    if (columns.isDefined) {p.columns = columns.map(v => v.value)}
    if (container.isDefined) {p.container = container}
    if (divided.isDefined) {p.divided = divided}
    if (doubling.isDefined) {p.doubling = doubling}
    if (inverted.isDefined) {p.inverted = inverted}
    if (key.isDefined) {p.key = key}
    if (padded.isDefined) {p.padded = padded}
    if (relaxed.isDefined) {p.relaxed = relaxed}
    if (reversed.isDefined) {p.reversed = reversed}
    if (stackable.isDefined) {p.stackable = stackable}
    if (stretched.isDefined) {p.stretched = stretched}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (textAlign.isDefined) {p.textAlign = textAlign.map(v => v.value)}
    if (verticalAlign.isDefined) {p.verticalAlign = verticalAlign.map(v => v.value)}

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
        