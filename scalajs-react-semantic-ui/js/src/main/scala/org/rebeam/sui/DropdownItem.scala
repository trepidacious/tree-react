
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object DropdownItem {
  
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var description: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var flag: js.UndefOr[js.Any] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var image: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var label: js.UndefOr[js.Any] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var selected: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var text: js.UndefOr[js.Any] = js.native
    var value: js.UndefOr[js.Any] = js.native
  }

  @JSImport("semantic-ui-react", "DropdownItem")
  @js.native
  object DropdownItemJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](DropdownItemJS)
  
  /**
   * An item sub-component for Dropdown component.
   * @param active
   *        Style as the currently chosen item.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param description
   *        Additional text with less emphasis.
   * @param disabled
   *        A dropdown item can be disabled.
   * @param flag
   *        Shorthand for Flag.
   * @param icon
   *        Shorthand for Icon.
   * @param image
   *        Shorthand for Image.
   * @param key
   *        React key
   * @param label
   *        Shorthand for Label.
   * @param onClick
   *        Called on click.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param selected
   *        The item currently selected by keyboard shortcut.
   *        This is not the active item.
   * @param style
   *        React element CSS style
   * @param text
   *        Display text.
   * @param value
   *        Stored value.
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
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    description: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    flag: js.UndefOr[js.Any] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    image: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[js.Any] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    selected: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    text: js.UndefOr[js.Any] = js.undefined,
    value: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (description.isDefined) {p.description = description}
    if (disabled.isDefined) {p.disabled = disabled}
    if (flag.isDefined) {p.flag = flag}
    if (icon.isDefined) {p.icon = icon}
    if (image.isDefined) {p.image = image}
    if (key.isDefined) {p.key = key}
    if (label.isDefined) {p.label = label}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (selected.isDefined) {p.selected = selected}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (text.isDefined) {p.text = text}
    if (value.isDefined) {p.value = value}

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
        