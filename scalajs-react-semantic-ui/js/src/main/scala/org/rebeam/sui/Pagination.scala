
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Pagination {
  
  @js.native
  trait Props extends js.Object {
    var activePage: js.UndefOr[js.Any] = js.native
    var `aria-label`: js.UndefOr[String] = js.native
    var boundaryRange: js.UndefOr[js.Any] = js.native
    var defaultActivePage: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var ellipsisItem: js.UndefOr[js.Any] = js.native
    var firstItem: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var lastItem: js.UndefOr[js.Any] = js.native
    var nextItem: js.UndefOr[js.Any] = js.native
    var onPageChange: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var pageItem: js.UndefOr[js.Any] = js.native
    var prevItem: js.UndefOr[js.Any] = js.native
    var siblingRange: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var totalPages: js.Any = js.native
  }

  @JSImport("semantic-ui-react", "Pagination")
  @js.native
  object PaginationJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](PaginationJS)
  
  /**
   * A component to render a pagination.
   * @param activePage
   *        Index of the currently active page.
   * @param aria-label
   *        A pagination item can have an aria label.
   * @param boundaryRange
   *        Number of always visible pages at the beginning and end.
   * @param defaultActivePage
   *        Initial activePage value.
   * @param disabled
   *        A pagination can be disabled.
   * @param ellipsisItem
   *        A shorthand for PaginationItem.
   * @param firstItem
   *        A shorthand for PaginationItem.
   * @param key
   *        React key
   * @param lastItem
   *        A shorthand for PaginationItem.
   * @param nextItem
   *        A shorthand for PaginationItem.
   * @param onPageChange
   *        Called on change of an active page.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param pageItem
   *        A shorthand for PaginationItem.
   * @param prevItem
   *        A shorthand for PaginationItem.
   * @param siblingRange
   *        Number of always visible pages before and after the current one.
   * @param style
   *        React element CSS style
   * @param totalPages
   *        Total number of pages.
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
    activePage: js.UndefOr[js.Any] = js.undefined,
    ariaLabel: js.UndefOr[String] = js.undefined,
    boundaryRange: js.UndefOr[js.Any] = js.undefined,
    defaultActivePage: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    ellipsisItem: js.UndefOr[js.Any] = js.undefined,
    firstItem: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    lastItem: js.UndefOr[js.Any] = js.undefined,
    nextItem: js.UndefOr[js.Any] = js.undefined,
    onPageChange: js.UndefOr[Callback] = js.undefined,
    pageItem: js.UndefOr[js.Any] = js.undefined,
    prevItem: js.UndefOr[js.Any] = js.undefined,
    siblingRange: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    totalPages: js.Any,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (activePage.isDefined) {p.activePage = activePage}
    if (ariaLabel.isDefined) {p.`aria-label` = ariaLabel}
    if (boundaryRange.isDefined) {p.boundaryRange = boundaryRange}
    if (defaultActivePage.isDefined) {p.defaultActivePage = defaultActivePage}
    if (disabled.isDefined) {p.disabled = disabled}
    if (ellipsisItem.isDefined) {p.ellipsisItem = ellipsisItem}
    if (firstItem.isDefined) {p.firstItem = firstItem}
    if (key.isDefined) {p.key = key}
    if (lastItem.isDefined) {p.lastItem = lastItem}
    if (nextItem.isDefined) {p.nextItem = nextItem}
    if (onPageChange.isDefined) {p.onPageChange = onPageChange.map(v => v.toJsFn)}
    if (pageItem.isDefined) {p.pageItem = pageItem}
    if (prevItem.isDefined) {p.prevItem = prevItem}
    if (siblingRange.isDefined) {p.siblingRange = siblingRange}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    p.totalPages = totalPages

    additionalProps.foreach {
      a => {
        val dict = a.asInstanceOf[js.Dictionary[js.Any]]
        val pDict = p.asInstanceOf[js.Dictionary[js.Any]]
        for ((prop, value) <- dict) {
          if (!p.hasOwnProperty(prop)) pDict(prop) = value
        }
      }
    }
    
    jsComponent(p)
  }

}
        