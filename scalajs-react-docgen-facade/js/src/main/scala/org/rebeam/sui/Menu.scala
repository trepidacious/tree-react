
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Menu {
  
  sealed trait Color{ val value: String }

  object Color {
    case object Grey extends Color { val value: String = "grey" }
    case object Teal extends Color { val value: String = "teal" }
    case object Black extends Color { val value: String = "black" }
    case object Purple extends Color { val value: String = "purple" }
    case object Violet extends Color { val value: String = "violet" }
    case object Green extends Color { val value: String = "green" }
    case object Orange extends Color { val value: String = "orange" }
    case object Yellow extends Color { val value: String = "yellow" }
    case object Olive extends Color { val value: String = "olive" }
    case object Red extends Color { val value: String = "red" }
    case object Brown extends Color { val value: String = "brown" }
    case object Blue extends Color { val value: String = "blue" }
    case object Pink extends Color { val value: String = "pink" }
  }
            
  sealed trait Fixed{ val value: String }

  object Fixed {
    case object Left extends Fixed { val value: String = "left" }
    case object Right extends Fixed { val value: String = "right" }
    case object Bottom extends Fixed { val value: String = "bottom" }
    case object Top extends Fixed { val value: String = "top" }
  }
            
  sealed trait Size{ val value: String }

  object Size {
    case object Mini extends Size { val value: String = "mini" }
    case object Tiny extends Size { val value: String = "tiny" }
    case object Massive extends Size { val value: String = "massive" }
    case object Small extends Size { val value: String = "small" }
    case object Huge extends Size { val value: String = "huge" }
    case object Large extends Size { val value: String = "large" }
  }
            
  sealed trait Widths{ val value: String }

  object Widths {
    case object Fourteen extends Widths { val value: String = "fourteen" }
    case object Nine extends Widths { val value: String = "nine" }
    case object Six extends Widths { val value: String = "six" }
    case object Fifteen extends Widths { val value: String = "fifteen" }
    case object One extends Widths { val value: String = "one" }
    case object Sixteen extends Widths { val value: String = "sixteen" }
    case object Seven extends Widths { val value: String = "seven" }
    case object _8 extends Widths { val value: String = "8" }
    case object _2 extends Widths { val value: String = "2" }
    case object Five extends Widths { val value: String = "five" }
    case object _12 extends Widths { val value: String = "12" }
    case object _9 extends Widths { val value: String = "9" }
    case object _5 extends Widths { val value: String = "5" }
    case object _6 extends Widths { val value: String = "6" }
    case object Ten extends Widths { val value: String = "ten" }
    case object _16 extends Widths { val value: String = "16" }
    case object _10 extends Widths { val value: String = "10" }
    case object _13 extends Widths { val value: String = "13" }
    case object Twelve extends Widths { val value: String = "twelve" }
    case object Thirteen extends Widths { val value: String = "thirteen" }
    case object Eight extends Widths { val value: String = "eight" }
    case object Eleven extends Widths { val value: String = "eleven" }
    case object _1 extends Widths { val value: String = "1" }
    case object _3 extends Widths { val value: String = "3" }
    case object _14 extends Widths { val value: String = "14" }
    case object _4 extends Widths { val value: String = "4" }
    case object Three extends Widths { val value: String = "three" }
    case object _15 extends Widths { val value: String = "15" }
    case object Four extends Widths { val value: String = "four" }
    case object Two extends Widths { val value: String = "two" }
    case object _11 extends Widths { val value: String = "11" }
    case object _7 extends Widths { val value: String = "7" }
  }
          
  @js.native
  trait Props extends js.Object {
    var activeIndex: js.UndefOr[js.Any] = js.native
    var as: js.UndefOr[js.Any] = js.native
    var attached: js.UndefOr[js.Any] = js.native
    var borderless: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var color: js.UndefOr[String] = js.native
    var compact: js.UndefOr[Boolean] = js.native
    var defaultActiveIndex: js.UndefOr[js.Any] = js.native
    var fixed: js.UndefOr[String] = js.native
    var floated: js.UndefOr[js.Any] = js.native
    var fluid: js.UndefOr[Boolean] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var inverted: js.UndefOr[Boolean] = js.native
    var items: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var onItemClick: js.UndefOr[js.Any] = js.native
    var pagination: js.UndefOr[Boolean] = js.native
    var pointing: js.UndefOr[Boolean] = js.native
    var secondary: js.UndefOr[Boolean] = js.native
    var size: js.UndefOr[String] = js.native
    var stackable: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var tabular: js.UndefOr[js.Any] = js.native
    var text: js.UndefOr[Boolean] = js.native
    var vertical: js.UndefOr[Boolean] = js.native
    var widths: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "Menu")
  @js.native
  object MenuJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](MenuJS)
  
  /**
   * A menu displays grouped navigation actions.
   * @see Dropdown
   * @param activeIndex
   *        Index of the currently active item.
   * @param as
   *        An element type to render as (string or function).
   * @param attached
   *        A menu may be attached to other content segments.
   * @param borderless
   *        A menu item or menu can have no borders.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param color
   *        Additional colors can be specified.
   * @param compact
   *        A menu can take up only the space necessary to fit its content.
   * @param defaultActiveIndex
   *        Initial activeIndex value.
   * @param fixed
   *        A menu can be fixed to a side of its context.
   * @param floated
   *        A menu can be floated.
   * @param fluid
   *        A vertical menu may take the size of its container.
   * @param icon
   *        A menu may have just icons (bool) or labeled icons.
   * @param inverted
   *        A menu may have its colors inverted to show greater contrast.
   * @param items
   *        Shorthand array of props for Menu.
   * @param key
   *        React key
   * @param onItemClick
   *        onClick handler for MenuItem. Mutually exclusive with children.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All item props.
   * @param pagination
   *        A pagination menu is specially formatted to present links to pages of content.
   * @param pointing
   *        A menu can point to show its relationship to nearby content.
   * @param secondary
   *        A menu can adjust its appearance to de-emphasize its contents.
   * @param size
   *        A menu can vary in size.
   * @param stackable
   *        A menu can stack at mobile resolutions.
   * @param style
   *        React element CSS style
   * @param tabular
   *        A menu can be formatted to show tabs of information.
   * @param text
   *        A menu can be formatted for text content.
   * @param vertical
   *        A vertical menu displays elements vertically.
   * @param widths
   *        A menu can have its items divided evenly.
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
    attached: js.UndefOr[js.Any] = js.undefined,
    borderless: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    compact: js.UndefOr[Boolean] = js.undefined,
    defaultActiveIndex: js.UndefOr[js.Any] = js.undefined,
    fixed: js.UndefOr[Fixed] = js.undefined,
    floated: js.UndefOr[js.Any] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    items: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onItemClick: js.UndefOr[js.Any] = js.undefined,
    pagination: js.UndefOr[Boolean] = js.undefined,
    pointing: js.UndefOr[Boolean] = js.undefined,
    secondary: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    stackable: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    tabular: js.UndefOr[js.Any] = js.undefined,
    text: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined,
    widths: js.UndefOr[Widths] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (activeIndex.isDefined) {p.activeIndex = activeIndex}
    if (as.isDefined) {p.as = as}
    if (attached.isDefined) {p.attached = attached}
    if (borderless.isDefined) {p.borderless = borderless}
    if (className.isDefined) {p.className = className}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (compact.isDefined) {p.compact = compact}
    if (defaultActiveIndex.isDefined) {p.defaultActiveIndex = defaultActiveIndex}
    if (fixed.isDefined) {p.fixed = fixed.map(v => v.value)}
    if (floated.isDefined) {p.floated = floated}
    if (fluid.isDefined) {p.fluid = fluid}
    if (icon.isDefined) {p.icon = icon}
    if (inverted.isDefined) {p.inverted = inverted}
    if (items.isDefined) {p.items = items}
    if (key.isDefined) {p.key = key}
    if (onItemClick.isDefined) {p.onItemClick = onItemClick}
    if (pagination.isDefined) {p.pagination = pagination}
    if (pointing.isDefined) {p.pointing = pointing}
    if (secondary.isDefined) {p.secondary = secondary}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (stackable.isDefined) {p.stackable = stackable}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (tabular.isDefined) {p.tabular = tabular}
    if (text.isDefined) {p.text = text}
    if (vertical.isDefined) {p.vertical = vertical}
    if (widths.isDefined) {p.widths = widths.map(v => v.value)}

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
        