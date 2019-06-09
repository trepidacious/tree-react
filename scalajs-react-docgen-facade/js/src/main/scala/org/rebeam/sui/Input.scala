
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Input {
  
  sealed trait ActionPosition{ val value: String }

  object ActionPosition {
    case object Left extends ActionPosition { val value: String = "left" }
  }
            
  sealed trait IconPosition{ val value: String }

  object IconPosition {
    case object Left extends IconPosition { val value: String = "left" }
  }
            
  sealed trait LabelPosition{ val value: String }

  object LabelPosition {
    case object Left extends LabelPosition { val value: String = "left" }
    case object Right extends LabelPosition { val value: String = "right" }
    case object LeftCorner extends LabelPosition { val value: String = "left corner" }
    case object RightCorner extends LabelPosition { val value: String = "right corner" }
  }
            
  sealed trait Size{ val value: String }

  object Size {
    case object Mini extends Size { val value: String = "mini" }
    case object Massive extends Size { val value: String = "massive" }
    case object Small extends Size { val value: String = "small" }
    case object Big extends Size { val value: String = "big" }
    case object Huge extends Size { val value: String = "huge" }
    case object Large extends Size { val value: String = "large" }
  }
          
  @js.native
  trait Props extends js.Object {
    var action: js.UndefOr[js.Any] = js.native
    var actionPosition: js.UndefOr[String] = js.native
    var as: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var error: js.UndefOr[Boolean] = js.native
    var fluid: js.UndefOr[Boolean] = js.native
    var focus: js.UndefOr[Boolean] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var iconPosition: js.UndefOr[String] = js.native
    var input: js.UndefOr[js.Any] = js.native
    var inverted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var label: js.UndefOr[js.Any] = js.native
    var labelPosition: js.UndefOr[String] = js.native
    var loading: js.UndefOr[Boolean] = js.native
    var onChange: js.UndefOr[scalajs.js.Function1[ReactEvent, Unit]] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var tabIndex: js.UndefOr[js.Any] = js.native
    var transparent: js.UndefOr[Boolean] = js.native
    var `type`: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "Input")
  @js.native
  object InputJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](InputJS)
  
  /**
   * An Input is a field used to elicit a response from a user.
   * @see Button
   * @see Form
   * @see Icon
   * @see Label
   * @param action
   *        An Input can be formatted to alert the user to an action they may perform.
   * @param actionPosition
   *        An action can appear along side an Input on the left or right.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param disabled
   *        An Input field can show that it is disabled.
   * @param error
   *        An Input field can show the data contains errors.
   * @param fluid
   *        Take on the size of its container.
   * @param focus
   *        An Input field can show a user is currently interacting with it.
   * @param icon
   *        Optional Icon to display inside the Input.
   * @param iconPosition
   *        An Icon can appear inside an Input on the left or right.
   * @param input
   *        Shorthand for creating the HTML Input.
   * @param inverted
   *        Format to appear on dark backgrounds.
   * @param key
   *        React key
   * @param label
   *        Optional Label to display along side the Input.
   * @param labelPosition
   *        A Label can appear outside an Input on the left or right.
   * @param loading
   *        An Icon Input field can show that it is currently loading data.
   * @param onChange
   *        Called on change.
   *        
   *        parameter {ChangeEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props and a proposed value.
   * @param size
   *        An Input can vary in size.
   * @param style
   *        React element CSS style
   * @param tabIndex
   *        An Input can receive focus.
   * @param transparent
   *        Transparent Input has no background.
   * @param `type`
   *        The HTML input type.
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
    action: js.UndefOr[js.Any] = js.undefined,
    actionPosition: js.UndefOr[ActionPosition] = js.undefined,
    as: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    focus: js.UndefOr[Boolean] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    iconPosition: js.UndefOr[IconPosition] = js.undefined,
    input: js.UndefOr[js.Any] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[js.Any] = js.undefined,
    labelPosition: js.UndefOr[LabelPosition] = js.undefined,
    loading: js.UndefOr[Boolean] = js.undefined,
    onChange: js.UndefOr[ReactEvent => Callback] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    tabIndex: js.UndefOr[js.Any] = js.undefined,
    transparent: js.UndefOr[Boolean] = js.undefined,
    `type`: js.UndefOr[String] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (action.isDefined) {p.action = action}
    if (actionPosition.isDefined) {p.actionPosition = actionPosition.map(v => v.value)}
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (disabled.isDefined) {p.disabled = disabled}
    if (error.isDefined) {p.error = error}
    if (fluid.isDefined) {p.fluid = fluid}
    if (focus.isDefined) {p.focus = focus}
    if (icon.isDefined) {p.icon = icon}
    if (iconPosition.isDefined) {p.iconPosition = iconPosition.map(v => v.value)}
    if (input.isDefined) {p.input = input}
    if (inverted.isDefined) {p.inverted = inverted}
    if (key.isDefined) {p.key = key}
    if (label.isDefined) {p.label = label}
    if (labelPosition.isDefined) {p.labelPosition = labelPosition.map(v => v.value)}
    if (loading.isDefined) {p.loading = loading}
    if (onChange.isDefined) {p.onChange = onChange.map(v => (e: ReactEvent) => v(e).runNow())}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (tabIndex.isDefined) {p.tabIndex = tabIndex}
    if (transparent.isDefined) {p.transparent = transparent}
    if (`type`.isDefined) {p.`type` = `type`}

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
        