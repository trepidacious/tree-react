
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Radio {
  
  sealed trait Color{ val value: String }

  object Color {
    case object Primary extends Color { val value: String = "primary" }
    case object Secondary extends Color { val value: String = "secondary" }
    case object Default extends Color { val value: String = "default" }
  }
          
  @js.native
  trait Props extends js.Object {
    var checked: js.UndefOr[js.Any] = js.native
    var checkedIcon: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var color: js.UndefOr[String] = js.native
    var disableRipple: js.UndefOr[Boolean] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var icon: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var id: js.UndefOr[String] = js.native
    var inputProps: js.UndefOr[js.Object] = js.native
    var inputRef: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var onChange: js.UndefOr[scalajs.js.Function1[ReactEvent, Unit]] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var `type`: js.UndefOr[String] = js.native
    var value: js.UndefOr[js.Any] = js.native
  }

  @JSImport("@material-ui/core/Radio", JSImport.Default)
  @js.native
  object RadioJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.None](RadioJS)
  
  /**
   * 
   * @param checked
   *        If `true`, the component is checked.
   * @param checkedIcon
   *        The icon to display when the component is checked.
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param color
   *        The color of the component. It supports those theme colors that make sense for this component.
   * @param disableRipple
   *        If `true`, the ripple effect will be disabled.
   * @param disabled
   *        If `true`, the switch will be disabled.
   * @param icon
   *        The icon to display when the component is unchecked.
   * @param id
   *        The id of the `input` element.
   * @param inputProps
   *        Attributes applied to the `input` element.
   * @param inputRef
   *        Use that property to pass a ref callback to the native input component.
   * @param key
   *        React key
   * @param onChange
   *        Callback fired when the state is changed.
   *        
   *        parameter {object} event The event source of the callback.
   *        You can pull out the new value by accessing `event.target.value`.
   *        parameter {boolean} checked The `checked` value of the switch
   * @param style
   *        React element CSS style
   * @param `type`
   *        The input component property `type`.
   * @param value
   *        The value of the component.
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
    checked: js.UndefOr[js.Any] = js.undefined,
    checkedIcon: js.UndefOr[VdomNode] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    disableRipple: js.UndefOr[Boolean] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    icon: js.UndefOr[VdomNode] = js.undefined,
    id: js.UndefOr[String] = js.undefined,
    inputProps: js.UndefOr[js.Object] = js.undefined,
    inputRef: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onChange: js.UndefOr[ReactEvent => Callback] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    `type`: js.UndefOr[String] = js.undefined,
    value: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (checked.isDefined) {p.checked = checked}
    if (checkedIcon.isDefined) {p.checkedIcon = checkedIcon.map(v => v.rawNode)}
    if (classes.isDefined) {p.classes = classes}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (disableRipple.isDefined) {p.disableRipple = disableRipple}
    if (disabled.isDefined) {p.disabled = disabled}
    if (icon.isDefined) {p.icon = icon.map(v => v.rawNode)}
    if (id.isDefined) {p.id = id}
    if (inputProps.isDefined) {p.inputProps = inputProps}
    if (inputRef.isDefined) {p.inputRef = inputRef}
    if (key.isDefined) {p.key = key}
    if (onChange.isDefined) {p.onChange = onChange.map(v => (e: ReactEvent) => v(e).runNow())}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (`type`.isDefined) {p.`type` = `type`}
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
        