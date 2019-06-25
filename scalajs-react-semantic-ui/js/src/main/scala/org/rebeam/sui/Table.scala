
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Table {
  
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
    case object Twelve extends Columns { val value: String = "twelve" }
    case object _10 extends Columns { val value: String = "10" }
    case object _12 extends Columns { val value: String = "12" }
    case object Sixteen extends Columns { val value: String = "sixteen" }
    case object _11 extends Columns { val value: String = "11" }
  }
            
  sealed trait Size{ val value: String }

  object Size {
    case object Small extends Size { val value: String = "small" }
    case object Large extends Size { val value: String = "large" }
  }
            
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
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var attached: js.UndefOr[js.Any] = js.native
    var basic: js.UndefOr[js.Any] = js.native
    var celled: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var collapsing: js.UndefOr[Boolean] = js.native
    var color: js.UndefOr[String] = js.native
    var columns: js.UndefOr[String] = js.native
    var compact: js.UndefOr[js.Any] = js.native
    var definition: js.UndefOr[Boolean] = js.native
    var fixed: js.UndefOr[Boolean] = js.native
    var footerRow: js.UndefOr[js.Any] = js.native
    var headerRow: js.UndefOr[js.Any] = js.native
    var headerRows: js.UndefOr[js.Any] = js.native
    var inverted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var padded: js.UndefOr[js.Any] = js.native
    var renderBodyRow: js.UndefOr[js.Any] = js.native
    var selectable: js.UndefOr[Boolean] = js.native
    var singleLine: js.UndefOr[Boolean] = js.native
    var size: js.UndefOr[String] = js.native
    var sortable: js.UndefOr[Boolean] = js.native
    var stackable: js.UndefOr[Boolean] = js.native
    var striped: js.UndefOr[Boolean] = js.native
    var structured: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var tableData: js.UndefOr[js.Any] = js.native
    var textAlign: js.UndefOr[String] = js.native
    var unstackable: js.UndefOr[Boolean] = js.native
    var verticalAlign: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "Table")
  @js.native
  object TableJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](TableJS)
  
  /**
   * A table displays a collections of data grouped into rows.
   * @param as
   *        An element type to render as (string or function).
   * @param attached
   *        Attach table to other content
   * @param basic
   *        A table can reduce its complexity to increase readability.
   * @param celled
   *        A table may be divided each row into separate cells.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param collapsing
   *        A table can be collapsing, taking up only as much space as its rows.
   * @param color
   *        A table can be given a color to distinguish it from other tables.
   * @param columns
   *        A table can specify its column count to divide its content evenly.
   * @param compact
   *        A table may sometimes need to be more compact to make more rows visible at a time.
   * @param definition
   *        A table may be formatted to emphasize a first column that defines a rows content.
   * @param fixed
   *        A table can use fixed a special faster form of table rendering that does not resize table cells based on content
   * @param footerRow
   *        Shorthand for a TableRow to be placed within Table.Footer.
   * @param headerRow
   *        Shorthand for a TableRow to be placed within Table.Header.
   * @param headerRows
   *        Shorthand for multiple TableRows to be placed within Table.Header.
   * @param inverted
   *        A table's colors can be inverted.
   * @param key
   *        React key
   * @param padded
   *        A table may sometimes need to be more padded for legibility.
   * @param renderBodyRow
   *        Mapped over `tableData` and should return shorthand for each Table.Row to be placed within Table.Body.
   *        
   *        parameter {*} data - An element in the `tableData` array.
   *        parameter {number} index - The index of the current element in `tableData`.
   *        returns {*} Shorthand for a Table.Row.
   * @param selectable
   *        A table can have its rows appear selectable.
   * @param singleLine
   *        A table can specify that its cell contents should remain on a single line and not wrap.
   * @param size
   *        A table can also be small or large.
   * @param sortable
   *        A table may allow a user to sort contents by clicking on a table header.
   * @param stackable
   *        A table can specify how it stacks table content responsively.
   * @param striped
   *        A table can stripe alternate rows of content with a darker color to increase contrast.
   * @param structured
   *        A table can be formatted to display complex structured data.
   * @param style
   *        React element CSS style
   * @param tableData
   *        Data to be passed to the renderBodyRow function.
   * @param textAlign
   *        A table can adjust its text alignment.
   * @param unstackable
   *        A table can specify how it stacks table content responsively.
   * @param verticalAlign
   *        A table can adjust its text alignment.
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
    basic: js.UndefOr[js.Any] = js.undefined,
    celled: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    collapsing: js.UndefOr[Boolean] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    columns: js.UndefOr[Columns] = js.undefined,
    compact: js.UndefOr[js.Any] = js.undefined,
    definition: js.UndefOr[Boolean] = js.undefined,
    fixed: js.UndefOr[Boolean] = js.undefined,
    footerRow: js.UndefOr[js.Any] = js.undefined,
    headerRow: js.UndefOr[js.Any] = js.undefined,
    headerRows: js.UndefOr[js.Any] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    padded: js.UndefOr[js.Any] = js.undefined,
    renderBodyRow: js.UndefOr[js.Any] = js.undefined,
    selectable: js.UndefOr[Boolean] = js.undefined,
    singleLine: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    sortable: js.UndefOr[Boolean] = js.undefined,
    stackable: js.UndefOr[Boolean] = js.undefined,
    striped: js.UndefOr[Boolean] = js.undefined,
    structured: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    tableData: js.UndefOr[js.Any] = js.undefined,
    textAlign: js.UndefOr[TextAlign] = js.undefined,
    unstackable: js.UndefOr[Boolean] = js.undefined,
    verticalAlign: js.UndefOr[VerticalAlign] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (attached.isDefined) {p.attached = attached}
    if (basic.isDefined) {p.basic = basic}
    if (celled.isDefined) {p.celled = celled}
    if (className.isDefined) {p.className = className}
    if (collapsing.isDefined) {p.collapsing = collapsing}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (columns.isDefined) {p.columns = columns.map(v => v.value)}
    if (compact.isDefined) {p.compact = compact}
    if (definition.isDefined) {p.definition = definition}
    if (fixed.isDefined) {p.fixed = fixed}
    if (footerRow.isDefined) {p.footerRow = footerRow}
    if (headerRow.isDefined) {p.headerRow = headerRow}
    if (headerRows.isDefined) {p.headerRows = headerRows}
    if (inverted.isDefined) {p.inverted = inverted}
    if (key.isDefined) {p.key = key}
    if (padded.isDefined) {p.padded = padded}
    if (renderBodyRow.isDefined) {p.renderBodyRow = renderBodyRow}
    if (selectable.isDefined) {p.selectable = selectable}
    if (singleLine.isDefined) {p.singleLine = singleLine}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (sortable.isDefined) {p.sortable = sortable}
    if (stackable.isDefined) {p.stackable = stackable}
    if (striped.isDefined) {p.striped = striped}
    if (structured.isDefined) {p.structured = structured}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (tableData.isDefined) {p.tableData = tableData}
    if (textAlign.isDefined) {p.textAlign = textAlign.map(v => v.value)}
    if (unstackable.isDefined) {p.unstackable = unstackable}
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
        