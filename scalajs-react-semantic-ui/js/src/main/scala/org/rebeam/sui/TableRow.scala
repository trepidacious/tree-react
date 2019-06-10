
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object TableRow {
  
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
    var active: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[js.Any] = js.native
    var cellAs: js.UndefOr[js.Any] = js.native
    var cells: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var error: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var negative: js.UndefOr[Boolean] = js.native
    var positive: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var textAlign: js.UndefOr[String] = js.native
    var verticalAlign: js.UndefOr[String] = js.native
    var warning: js.UndefOr[Boolean] = js.native
  }

  @JSImport("semantic-ui-react", "TableRow")
  @js.native
  object TableRowJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](TableRowJS)
  
  /**
   * A table can have rows.
   * @param active
   *        A row can be active or selected by a user.
   * @param as
   *        An element type to render as (string or function).
   * @param cellAs
   *        An element type to render as (string or function).
   * @param cells
   *        Shorthand array of props for TableCell.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param disabled
   *        A row can be disabled.
   * @param error
   *        A row may call attention to an error or a negative value.
   * @param key
   *        React key
   * @param negative
   *        A row may let a user know whether a value is bad.
   * @param positive
   *        A row may let a user know whether a value is good.
   * @param style
   *        React element CSS style
   * @param textAlign
   *        A table row can adjust its text alignment.
   * @param verticalAlign
   *        A table row can adjust its vertical alignment.
   * @param warning
   *        A row may warn a user.
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
    as: js.UndefOr[js.Any] = js.undefined,
    cellAs: js.UndefOr[js.Any] = js.undefined,
    cells: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    negative: js.UndefOr[Boolean] = js.undefined,
    positive: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    textAlign: js.UndefOr[TextAlign] = js.undefined,
    verticalAlign: js.UndefOr[VerticalAlign] = js.undefined,
    warning: js.UndefOr[Boolean] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (as.isDefined) {p.as = as}
    if (cellAs.isDefined) {p.cellAs = cellAs}
    if (cells.isDefined) {p.cells = cells}
    if (className.isDefined) {p.className = className}
    if (disabled.isDefined) {p.disabled = disabled}
    if (error.isDefined) {p.error = error}
    if (key.isDefined) {p.key = key}
    if (negative.isDefined) {p.negative = negative}
    if (positive.isDefined) {p.positive = positive}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (textAlign.isDefined) {p.textAlign = textAlign.map(v => v.value)}
    if (verticalAlign.isDefined) {p.verticalAlign = verticalAlign.map(v => v.value)}
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
        