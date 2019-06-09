
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

import js.JSConverters._

object Tab {
  
  sealed trait MenuPosition{ val value: String }

  object MenuPosition {
    case object Left extends MenuPosition { val value: String = "left" }
    case object Right extends MenuPosition { val value: String = "right" }
  }
          
  @js.native
  trait Props extends js.Object {
    var activeIndex: js.UndefOr[js.Any] = js.native
    var as: js.UndefOr[js.Any] = js.native
    var defaultActiveIndex: js.UndefOr[js.Any] = js.native
    var grid: js.UndefOr[js.Object] = js.native
    var key: js.UndefOr[String] = js.native
    var menu: js.UndefOr[js.Object] = js.native
    var menuPosition: js.UndefOr[String] = js.native
    var onTabChange: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var panes: js.UndefOr[js.Array[js.Any]] = js.native
    var renderActiveOnly: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "Tab")
  @js.native
  object TabJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](TabJS)
  
  /**
   * A Tab is a hidden section of content activated by a Menu.
   * @see Menu
   * @see Segment
   * @param activeIndex
   *        Index of the currently active tab.
   * @param as
   *        An element type to render as (string or function).
   * @param defaultActiveIndex
   *        The initial activeIndex.
   * @param grid
   *        Shorthand props for the Grid.
   * @param key
   *        React key
   * @param menu
   *        Shorthand props for the Menu.
   *        tabular, if true, will derive final value from `menuPosition`, otherwise set 'left' or 'right' explicitly.
   * @param menuPosition
   *        Align vertical menu
   * @param onTabChange
   *        Called on tab change.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props and proposed new activeIndex.
   *        parameter {object} data.activeIndex - The new proposed activeIndex.
   * @param panes
   *        Array of objects describing each Menu.Item and Tab.Pane:
   *        { menuItem: 'Home', render: () =&gt; &lt;Tab.Pane /&gt; }
   *        or
   *        { menuItem: 'Home', pane: 'Welcome' }
   * @param renderActiveOnly
   *        A Tab can render only active pane.
   * @param style
   *        React element CSS style
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
    activeIndex: js.UndefOr[js.Any] = js.undefined,
    as: js.UndefOr[js.Any] = js.undefined,
    defaultActiveIndex: js.UndefOr[js.Any] = js.undefined,
    grid: js.UndefOr[js.Object] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    menu: js.UndefOr[js.Object] = js.undefined,
    menuPosition: js.UndefOr[MenuPosition] = js.undefined,
    onTabChange: js.UndefOr[Callback] = js.undefined,
    panes: js.UndefOr[Seq[js.Any]] = js.undefined,
    renderActiveOnly: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (activeIndex.isDefined) {p.activeIndex = activeIndex}
    if (as.isDefined) {p.as = as}
    if (defaultActiveIndex.isDefined) {p.defaultActiveIndex = defaultActiveIndex}
    if (grid.isDefined) {p.grid = grid}
    if (key.isDefined) {p.key = key}
    if (menu.isDefined) {p.menu = menu}
    if (menuPosition.isDefined) {p.menuPosition = menuPosition.map(v => v.value)}
    if (onTabChange.isDefined) {p.onTabChange = onTabChange.map(v => v.toJsFn)}
    if (panes.isDefined) {p.panes = panes.map(v => v.map(e => e).toJSArray)}
    if (renderActiveOnly.isDefined) {p.renderActiveOnly = renderActiveOnly}
    if (style.isDefined) {p.style = style.map(v => v.o)}

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
        