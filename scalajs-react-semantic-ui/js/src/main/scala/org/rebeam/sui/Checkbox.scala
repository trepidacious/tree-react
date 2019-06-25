
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Checkbox {
  
  sealed trait `type`{ val value: String }

  object `type` {
    case object Checkbox extends `type` { val value: String = "checkbox" }
    case object Radio extends `type` { val value: String = "radio" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var checked: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var defaultChecked: js.UndefOr[Boolean] = js.native
    var defaultIndeterminate: js.UndefOr[Boolean] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var fitted: js.UndefOr[Boolean] = js.native
    var id: js.UndefOr[js.Any] = js.native
    var indeterminate: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var label: js.UndefOr[js.Any] = js.native
    var name: js.UndefOr[String] = js.native
    var onChange: js.UndefOr[scalajs.js.Function2[ReactEvent, Props, Unit]] = js.native
    var onClick: js.UndefOr[scalajs.js.Function2[ReactMouseEvent, Props, Unit]] = js.native
    var onMouseDown: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var onMouseUp: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var radio: js.UndefOr[js.Any] = js.native
    var readOnly: js.UndefOr[Boolean] = js.native
    var slider: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var tabIndex: js.UndefOr[js.Any] = js.native
    var toggle: js.UndefOr[js.Any] = js.native
    var `type`: js.UndefOr[String] = js.native
    var value: js.UndefOr[js.Any] = js.native
  }

  @JSImport("semantic-ui-react", "Checkbox")
  @js.native
  object CheckboxJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](CheckboxJS)
  
  /**
   * A checkbox allows a user to select a value from a small set of options, often binary.
   * @see Form
   * @see Radio
   * @param as
   *        An element type to render as (string or function).
   * @param checked
   *        Whether or not checkbox is checked.
   * @param className
   *        Additional classes.
   * @param defaultChecked
   *        The initial value of checked.
   * @param defaultIndeterminate
   *        Whether or not checkbox is indeterminate.
   * @param disabled
   *        A checkbox can appear disabled and be unable to change states
   * @param fitted
   *        Removes padding for a label. Auto applied when there is no label.
   * @param id
   *        A unique identifier.
   * @param indeterminate
   *        Whether or not checkbox is indeterminate.
   * @param key
   *        React key
   * @param label
   *        The text of the associated label element.
   * @param name
   *        The HTML input name.
   * @param onChange
   *        Called when the user attempts to change the checked state.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props and proposed checked/indeterminate state.
   * @param onClick
   *        Called when the checkbox or label is clicked.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props and current checked/indeterminate state.
   * @param onMouseDown
   *        Called when the user presses down on the mouse.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props and current checked/indeterminate state.
   * @param onMouseUp
   *        Called when the user releases the mouse.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props and current checked/indeterminate state.
   * @param radio
   *        Format as a radio element. This means it is an exclusive option.
   * @param readOnly
   *        A checkbox can be read-only and unable to change states.
   * @param slider
   *        Format to emphasize the current selection state.
   * @param style
   *        React element CSS style
   * @param tabIndex
   *        A checkbox can receive focus.
   * @param toggle
   *        Format to show an on or off choice.
   * @param `type`
   *        HTML input type, either checkbox or radio.
   * @param value
   *        The HTML input value.
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
    checked: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    defaultChecked: js.UndefOr[Boolean] = js.undefined,
    defaultIndeterminate: js.UndefOr[Boolean] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    fitted: js.UndefOr[Boolean] = js.undefined,
    id: js.UndefOr[js.Any] = js.undefined,
    indeterminate: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[js.Any] = js.undefined,
    name: js.UndefOr[String] = js.undefined,
    onChange: js.UndefOr[(ReactEvent, Props) => Callback] = js.undefined,
    onClick: js.UndefOr[(ReactMouseEvent, Props) => Callback] = js.undefined,
    onMouseDown: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    onMouseUp: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    radio: js.UndefOr[js.Any] = js.undefined,
    readOnly: js.UndefOr[Boolean] = js.undefined,
    slider: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    tabIndex: js.UndefOr[js.Any] = js.undefined,
    toggle: js.UndefOr[js.Any] = js.undefined,
    `type`: js.UndefOr[`type`] = js.undefined,
    value: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (checked.isDefined) {p.checked = checked}
    if (className.isDefined) {p.className = className}
    if (defaultChecked.isDefined) {p.defaultChecked = defaultChecked}
    if (defaultIndeterminate.isDefined) {p.defaultIndeterminate = defaultIndeterminate}
    if (disabled.isDefined) {p.disabled = disabled}
    if (fitted.isDefined) {p.fitted = fitted}
    if (id.isDefined) {p.id = id}
    if (indeterminate.isDefined) {p.indeterminate = indeterminate}
    if (key.isDefined) {p.key = key}
    if (label.isDefined) {p.label = label}
    if (name.isDefined) {p.name = name}
    if (onChange.isDefined) {p.onChange = onChange.map(v => (e: ReactEvent, p: Props) => v(e, p).runNow())}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent, p: Props) => v(e, p).runNow())}
    if (onMouseDown.isDefined) {p.onMouseDown = onMouseDown.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (onMouseUp.isDefined) {p.onMouseUp = onMouseUp.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (radio.isDefined) {p.radio = radio}
    if (readOnly.isDefined) {p.readOnly = readOnly}
    if (slider.isDefined) {p.slider = slider}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (tabIndex.isDefined) {p.tabIndex = tabIndex}
    if (toggle.isDefined) {p.toggle = toggle}
    if (`type`.isDefined) {p.`type` = `type`.map(v => v.value)}
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
    
    jsComponent(p)
  }

}
        