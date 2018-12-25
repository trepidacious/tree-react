
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object MenuItem {
  
  sealed trait AlignItems{ val value: String }

  object AlignItems {
    case object FlexStart extends AlignItems { val value: String = "flex-start" }
    case object Center extends AlignItems { val value: String = "center" }
  }
          
  @js.native
  trait Props extends js.Object {
    var ContainerComponent: js.UndefOr[js.Any] = js.native
    var ContainerProps: js.UndefOr[js.Object] = js.native
    var alignItems: js.UndefOr[String] = js.native
    var button: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var dense: js.UndefOr[Boolean] = js.native
    var disableGutters: js.UndefOr[Boolean] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var divider: js.UndefOr[Boolean] = js.native
    var focusVisibleClassName: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var role: js.UndefOr[String] = js.native
    var selected: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/MenuItem", JSImport.Default)
  @js.native
  object MenuItemJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](MenuItemJS)
  
  /**
   * 
   * @param ContainerComponent
   *        The container component used when a `ListItemSecondaryAction` is rendered.
   *        Passed to ListItem
   * @param ContainerProps
   *        Properties applied to the container element when the component
   *        is used to display a `ListItemSecondaryAction`.
   *        Passed to ListItem
   * @param alignItems
   *        Defines the `align-items` style property.
   *        Passed to ListItem
   * @param button
   *        If `true`, the list item will be a button (using `ButtonBase`).
   *        Passed to ListItem
   * @param children
   *        Menu item contents.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param dense
   *        If `true`, compact vertical padding designed for keyboard and mouse input will be used.
   *        Passed to ListItem
   * @param disableGutters
   *        If `true`, the left and right padding is removed.
   * @param disabled
   *        If `true`, the list item will be disabled.
   *        Passed to ListItem
   * @param divider
   *        If `true`, a 1px light border is added to the bottom of the list item.
   *        Passed to ListItem
   * @param focusVisibleClassName
   *        Property spread to root element
   *        Passed to ListItem
   * @param key
   *        React key
   * @param onClick
   *        ReactMouseEvent on click
   *        Passed to DOCGEN_OnClickBase
   * @param role
   *        Property spread to root element
   * @param selected
   *        Property spread to root element
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
    ContainerComponent: js.UndefOr[js.Any] = js.undefined,
    ContainerProps: js.UndefOr[js.Object] = js.undefined,
    alignItems: js.UndefOr[AlignItems] = js.undefined,
    button: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    dense: js.UndefOr[Boolean] = js.undefined,
    disableGutters: js.UndefOr[Boolean] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    divider: js.UndefOr[Boolean] = js.undefined,
    focusVisibleClassName: js.UndefOr[String] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    role: js.UndefOr[String] = js.undefined,
    selected: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (ContainerComponent.isDefined) {p.ContainerComponent = ContainerComponent}
    if (ContainerProps.isDefined) {p.ContainerProps = ContainerProps}
    if (alignItems.isDefined) {p.alignItems = alignItems.map(v => v.value)}
    if (button.isDefined) {p.button = button}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (dense.isDefined) {p.dense = dense}
    if (disableGutters.isDefined) {p.disableGutters = disableGutters}
    if (disabled.isDefined) {p.disabled = disabled}
    if (divider.isDefined) {p.divider = divider}
    if (focusVisibleClassName.isDefined) {p.focusVisibleClassName = focusVisibleClassName}
    if (key.isDefined) {p.key = key}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (role.isDefined) {p.role = role}
    if (selected.isDefined) {p.selected = selected}
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
    
    jsComponent(p)(children: _*)
  }

}
        