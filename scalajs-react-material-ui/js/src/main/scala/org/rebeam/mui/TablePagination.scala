
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object TablePagination {
  
  sealed trait Align{ val value: String }

  object Align {
    case object Center extends Align { val value: String = "center" }
    case object Left extends Align { val value: String = "left" }
    case object Justify extends Align { val value: String = "justify" }
    case object Right extends Align { val value: String = "right" }
    case object Inherit extends Align { val value: String = "inherit" }
  }
            
  sealed trait Padding{ val value: String }

  object Padding {
    case object Default extends Padding { val value: String = "default" }
    case object Checkbox extends Padding { val value: String = "checkbox" }
    case object Dense extends Padding { val value: String = "dense" }
    case object None extends Padding { val value: String = "none" }
  }
            
  sealed trait SortDirection{ val value: String }

  object SortDirection {
    case object Asc extends SortDirection { val value: String = "asc" }
    case object Desc extends SortDirection { val value: String = "desc" }
    case object False extends SortDirection { val value: String = "false" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Head extends Variant { val value: String = "head" }
    case object Body extends Variant { val value: String = "body" }
    case object Footer extends Variant { val value: String = "footer" }
  }
          
  @js.native
  trait Props extends js.Object {
    var ActionsComponent: js.UndefOr[js.Any] = js.native
    var SelectProps: js.UndefOr[js.Object] = js.native
    var align: js.UndefOr[String] = js.native
    var backIconButtonProps: js.UndefOr[js.Object] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var colSpan: js.UndefOr[Double] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var count: Double = js.native
    var key: js.UndefOr[String] = js.native
    var labelDisplayedRows: js.UndefOr[js.Any] = js.native
    var labelRowsPerPage: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var nextIconButtonProps: js.UndefOr[js.Object] = js.native
    var numeric: js.UndefOr[Boolean] = js.native
    var onChangePage: scalajs.js.Function0[Unit] = js.native
    var onChangeRowsPerPage: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var padding: js.UndefOr[String] = js.native
    var page: Double = js.native
    var rowsPerPage: Double = js.native
    var rowsPerPageOptions: js.UndefOr[List[js.Any]] = js.native
    var scope: js.UndefOr[String] = js.native
    var sortDirection: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/TablePagination", JSImport.Default)
  @js.native
  object TablePaginationJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](TablePaginationJS)
  
  /**
   * A `TableCell` based component for placing inside `TableFooter` for pagination.
   * @param ActionsComponent
   *        The component used for displaying the actions.
   *        Either a string to use a DOM element or a component.
   * @param SelectProps
   *        Properties applied to the rows per page [`Select`](/api/select/) element.
   * @param align
   *        Set the text-align on the table cell content.
   *        
   *        Monetary or generally number fields **should be right aligned** as that allows
   *        you to add them up quickly in your head without having to worry about decimals.
   *        Passed to TableCell
   * @param backIconButtonProps
   *        Properties applied to the back arrow [`IconButton`](/api/icon-button/) component.
   * @param children
   *        The table cell contents.
   *        Passed to TableCell
   * @param className
   *        Property spread to root element
   *        Passed to TableCell
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param colSpan
   *        Property spread to root element
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param count
   *        The total number of rows.
   * @param key
   *        React key
   * @param labelDisplayedRows
   *        Customize the displayed rows label.
   * @param labelRowsPerPage
   *        Customize the rows per page label. Invoked with a `{ from, to, count, page }`
   *        object.
   * @param nextIconButtonProps
   *        Properties applied to the next arrow [`IconButton`](/api/icon-button/) element.
   * @param numeric
   *        If `true`, content will align to the right. Deprecated: Instead, use the `align` property.
   *        Passed to TableCell
   * @param onChangePage
   *        Callback fired when the page is changed.
   *        
   *        parameter {object} event The event source of the callback
   *        parameter {number} page The page selected
   * @param onChangeRowsPerPage
   *        Callback fired when the number of rows per page is changed.
   *        
   *        parameter {object} event The event source of the callback
   * @param padding
   *        Sets the padding applied to the cell.
   *        By default, the Table parent component set the value.
   *        Passed to TableCell
   * @param page
   *        The zero-based index of the current page.
   * @param rowsPerPage
   *        The number of rows per page.
   * @param rowsPerPageOptions
   *        Customizes the options of the rows per page select field. If less than two options are
   *        available, no select field will be displayed.
   * @param scope
   *        Set scope attribute.
   *        Passed to TableCell
   * @param sortDirection
   *        Set aria-sort direction.
   *        Passed to TableCell
   * @param style
   *        React element CSS style
   * @param variant
   *        Specify the cell type.
   *        By default, the TableHead, TableBody or TableFooter parent component set the value.
   *        Passed to TableCell
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
    ActionsComponent: js.UndefOr[js.Any] = js.undefined,
    SelectProps: js.UndefOr[js.Object] = js.undefined,
    align: js.UndefOr[Align] = js.undefined,
    backIconButtonProps: js.UndefOr[js.Object] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    colSpan: js.UndefOr[Double] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    count: Double,
    key: js.UndefOr[String] = js.undefined,
    labelDisplayedRows: js.UndefOr[js.Any] = js.undefined,
    labelRowsPerPage: js.UndefOr[VdomNode] = js.undefined,
    nextIconButtonProps: js.UndefOr[js.Object] = js.undefined,
    numeric: js.UndefOr[Boolean] = js.undefined,
    onChangePage: Callback,
    onChangeRowsPerPage: js.UndefOr[Callback] = js.undefined,
    padding: js.UndefOr[Padding] = js.undefined,
    page: Double,
    rowsPerPage: Double,
    rowsPerPageOptions: js.UndefOr[List[js.Any]] = js.undefined,
    scope: js.UndefOr[String] = js.undefined,
    sortDirection: js.UndefOr[SortDirection] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (ActionsComponent.isDefined) {p.ActionsComponent = ActionsComponent}
    if (SelectProps.isDefined) {p.SelectProps = SelectProps}
    if (align.isDefined) {p.align = align.map(v => v.value)}
    if (backIconButtonProps.isDefined) {p.backIconButtonProps = backIconButtonProps}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (colSpan.isDefined) {p.colSpan = colSpan}
    if (component.isDefined) {p.component = component}
    p.count = count
    if (key.isDefined) {p.key = key}
    if (labelDisplayedRows.isDefined) {p.labelDisplayedRows = labelDisplayedRows}
    if (labelRowsPerPage.isDefined) {p.labelRowsPerPage = labelRowsPerPage.map(v => v.rawNode)}
    if (nextIconButtonProps.isDefined) {p.nextIconButtonProps = nextIconButtonProps}
    if (numeric.isDefined) {p.numeric = numeric}
    p.onChangePage = onChangePage.toJsFn
    if (onChangeRowsPerPage.isDefined) {p.onChangeRowsPerPage = onChangeRowsPerPage.map(v => v.toJsFn)}
    if (padding.isDefined) {p.padding = padding.map(v => v.value)}
    p.page = page
    p.rowsPerPage = rowsPerPage
    if (rowsPerPageOptions.isDefined) {p.rowsPerPageOptions = rowsPerPageOptions}
    if (scope.isDefined) {p.scope = scope}
    if (sortDirection.isDefined) {p.sortDirection = sortDirection.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (variant.isDefined) {p.variant = variant.map(v => v.value)}

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
        