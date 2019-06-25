
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Button {
  
  sealed trait Color{ val value: String }

  object Color {
    case object Linkedin extends Color { val value: String = "linkedin" }
    case object Instagram extends Color { val value: String = "instagram" }
    case object Grey extends Color { val value: String = "grey" }
    case object GooglePlus extends Color { val value: String = "google plus" }
    case object Teal extends Color { val value: String = "teal" }
    case object Black extends Color { val value: String = "black" }
    case object Purple extends Color { val value: String = "purple" }
    case object Twitter extends Color { val value: String = "twitter" }
    case object Violet extends Color { val value: String = "violet" }
    case object Green extends Color { val value: String = "green" }
    case object Vk extends Color { val value: String = "vk" }
    case object Orange extends Color { val value: String = "orange" }
    case object Yellow extends Color { val value: String = "yellow" }
    case object Olive extends Color { val value: String = "olive" }
    case object Red extends Color { val value: String = "red" }
    case object Youtube extends Color { val value: String = "youtube" }
    case object Brown extends Color { val value: String = "brown" }
    case object Facebook extends Color { val value: String = "facebook" }
    case object Blue extends Color { val value: String = "blue" }
    case object Pink extends Color { val value: String = "pink" }
  }
            
  sealed trait Floated{ val value: String }

  object Floated {
    case object Left extends Floated { val value: String = "left" }
    case object Right extends Floated { val value: String = "right" }
  }
            
  sealed trait LabelPosition{ val value: String }

  object LabelPosition {
    case object Right extends LabelPosition { val value: String = "right" }
    case object Left extends LabelPosition { val value: String = "left" }
  }
            
  sealed trait Size{ val value: String }

  object Size {
    case object Mini extends Size { val value: String = "mini" }
    case object Tiny extends Size { val value: String = "tiny" }
    case object Massive extends Size { val value: String = "massive" }
    case object Small extends Size { val value: String = "small" }
    case object Medium extends Size { val value: String = "medium" }
    case object Big extends Size { val value: String = "big" }
    case object Huge extends Size { val value: String = "huge" }
    case object Large extends Size { val value: String = "large" }
  }
          
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var animated: js.UndefOr[js.Any] = js.native
    var as: js.UndefOr[String] = js.native
    var attached: js.UndefOr[js.Any] = js.native
    var basic: js.UndefOr[Boolean] = js.native
    var circular: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var color: js.UndefOr[String] = js.native
    var compact: js.UndefOr[Boolean] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var floated: js.UndefOr[String] = js.native
    var fluid: js.UndefOr[Boolean] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var inverted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var label: js.UndefOr[js.Any] = js.native
    var labelPosition: js.UndefOr[String] = js.native
    var loading: js.UndefOr[Boolean] = js.native
    var negative: js.UndefOr[Boolean] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var positive: js.UndefOr[Boolean] = js.native
    var primary: js.UndefOr[Boolean] = js.native
    var role: js.UndefOr[String] = js.native
    var secondary: js.UndefOr[Boolean] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var tabIndex: js.UndefOr[js.Any] = js.native
    var toggle: js.UndefOr[Boolean] = js.native
  }

  @JSImport("semantic-ui-react", "Button")
  @js.native
  object ButtonJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](ButtonJS)
  
  /**
   * A Button indicates a possible user action.
   * @see Form
   * @see Icon
   * @see Label
   * @param active
   *        A button can show it is currently the active user selection.
   * @param animated
   *        A button can animate to show hidden content.
   * @param as
   *        An element type to render as (string or function).
   * @param attached
   *        A button can be attached to other content.
   * @param basic
   *        A basic button is less pronounced.
   * @param children
   *        Primary content.
   * @param circular
   *        A button can be circular.
   * @param className
   *        Additional classes.
   * @param color
   *        A button can have different colors
   * @param compact
   *        A button can reduce its padding to fit into tighter spaces.
   * @param content
   *        Shorthand for primary content.
   * @param disabled
   *        A button can show it is currently unable to be interacted with.
   * @param floated
   *        A button can be aligned to the left or right of its container.
   * @param fluid
   *        A button can take the width of its container.
   * @param icon
   *        Add an Icon by name, props object, or pass an &lt;Icon /&gt;.
   * @param inverted
   *        A button can be formatted to appear on dark backgrounds.
   * @param key
   *        React key
   * @param label
   *        Add a Label by text, props object, or pass a &lt;Label /&gt;.
   * @param labelPosition
   *        A labeled button can format a Label or Icon to appear on the left or right.
   * @param loading
   *        A button can show a loading indicator.
   * @param negative
   *        A button can hint towards a negative consequence.
   * @param onClick
   *        Called after user's click.
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param positive
   *        A button can hint towards a positive consequence.
   * @param primary
   *        A button can be formatted to show different levels of emphasis.
   * @param role
   *        The role of the HTML element.
   * @param secondary
   *        A button can be formatted to show different levels of emphasis.
   * @param size
   *        A button can have different sizes.
   * @param style
   *        React element CSS style
   * @param tabIndex
   *        A button can receive focus.
   * @param toggle
   *        A button can be formatted to toggle on and off.
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
    animated: js.UndefOr[js.Any] = js.undefined,
    as: js.UndefOr[String] = js.undefined,
    attached: js.UndefOr[js.Any] = js.undefined,
    basic: js.UndefOr[Boolean] = js.undefined,
    circular: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    compact: js.UndefOr[Boolean] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    floated: js.UndefOr[Floated] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[js.Any] = js.undefined,
    labelPosition: js.UndefOr[LabelPosition] = js.undefined,
    loading: js.UndefOr[Boolean] = js.undefined,
    negative: js.UndefOr[Boolean] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    positive: js.UndefOr[Boolean] = js.undefined,
    primary: js.UndefOr[Boolean] = js.undefined,
    role: js.UndefOr[String] = js.undefined,
    secondary: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    tabIndex: js.UndefOr[js.Any] = js.undefined,
    toggle: js.UndefOr[Boolean] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (animated.isDefined) {p.animated = animated}
    if (as.isDefined) {p.as = as}
    if (attached.isDefined) {p.attached = attached}
    if (basic.isDefined) {p.basic = basic}
    if (circular.isDefined) {p.circular = circular}
    if (className.isDefined) {p.className = className}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (compact.isDefined) {p.compact = compact}
    if (content.isDefined) {p.content = content}
    if (disabled.isDefined) {p.disabled = disabled}
    if (floated.isDefined) {p.floated = floated.map(v => v.value)}
    if (fluid.isDefined) {p.fluid = fluid}
    if (icon.isDefined) {p.icon = icon}
    if (inverted.isDefined) {p.inverted = inverted}
    if (key.isDefined) {p.key = key}
    if (label.isDefined) {p.label = label}
    if (labelPosition.isDefined) {p.labelPosition = labelPosition.map(v => v.value)}
    if (loading.isDefined) {p.loading = loading}
    if (negative.isDefined) {p.negative = negative}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (positive.isDefined) {p.positive = positive}
    if (primary.isDefined) {p.primary = primary}
    if (role.isDefined) {p.role = role}
    if (secondary.isDefined) {p.secondary = secondary}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (tabIndex.isDefined) {p.tabIndex = tabIndex}
    if (toggle.isDefined) {p.toggle = toggle}

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
        