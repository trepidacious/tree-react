
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Chip {
  
  sealed trait Color{ val value: String }

  object Color {
    case object Default extends Color { val value: String = "default" }
    case object Primary extends Color { val value: String = "primary" }
    case object Secondary extends Color { val value: String = "secondary" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Default extends Variant { val value: String = "default" }
    case object Outlined extends Variant { val value: String = "outlined" }
  }
          
  @js.native
  trait Props extends js.Object {
    var avatar: js.UndefOr[japgolly.scalajs.react.raw.React.Element] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var clickable: js.UndefOr[Boolean] = js.native
    var color: js.UndefOr[String] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var deleteIcon: js.UndefOr[japgolly.scalajs.react.raw.React.Element] = js.native
    var icon: js.UndefOr[japgolly.scalajs.react.raw.React.Element] = js.native
    var key: js.UndefOr[String] = js.native
    var label: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var onDelete: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onKeyDown: js.UndefOr[scalajs.js.Function1[ReactKeyboardEvent, Unit]] = js.native
    var onKeyUp: js.UndefOr[scalajs.js.Function1[ReactKeyboardEvent, Unit]] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var tabIndex: js.UndefOr[js.Any] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/Chip", JSImport.Default)
  @js.native
  object ChipJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.None](ChipJS)
  
  /**
   * Chips represent complex entities in small blocks, such as a contact.
   * @param avatar
   *        Avatar element.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param clickable
   *        If true, the chip will appear clickable, and will raise when pressed,
   *        even if the onClick property is not defined. This can be used, for example,
   *        along with the component property to indicate an anchor Chip is clickable.
   * @param color
   *        The color of the component. It supports those theme colors that make sense for this component.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param deleteIcon
   *        Override the default delete icon element. Shown only if `onDelete` is set.
   * @param icon
   *        Icon element.
   * @param key
   *        React key
   * @param label
   *        The content of the label.
   * @param onClick
   *        Property spread to root element
   * @param onDelete
   *        Callback function fired when the delete icon is clicked.
   *        If set, the delete icon will be shown.
   * @param onKeyDown
   *        Property spread to root element
   * @param onKeyUp
   *        Property spread to root element
   * @param style
   *        React element CSS style
   * @param tabIndex
   *        Property spread to root element
   * @param variant
   *        The variant to use.
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
    avatar: js.UndefOr[VdomElement] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    clickable: js.UndefOr[Boolean] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    deleteIcon: js.UndefOr[VdomElement] = js.undefined,
    icon: js.UndefOr[VdomElement] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[VdomNode] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    onDelete: js.UndefOr[Callback] = js.undefined,
    onKeyDown: js.UndefOr[ReactKeyboardEvent => Callback] = js.undefined,
    onKeyUp: js.UndefOr[ReactKeyboardEvent => Callback] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    tabIndex: js.UndefOr[js.Any] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (avatar.isDefined) {p.avatar = avatar.map(v => v.rawElement)}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (clickable.isDefined) {p.clickable = clickable}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (component.isDefined) {p.component = component}
    if (deleteIcon.isDefined) {p.deleteIcon = deleteIcon.map(v => v.rawElement)}
    if (icon.isDefined) {p.icon = icon.map(v => v.rawElement)}
    if (key.isDefined) {p.key = key}
    if (label.isDefined) {p.label = label.map(v => v.rawNode)}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (onDelete.isDefined) {p.onDelete = onDelete.map(v => v.toJsFn)}
    if (onKeyDown.isDefined) {p.onKeyDown = onKeyDown.map(v => (e: ReactKeyboardEvent) => v(e).runNow())}
    if (onKeyUp.isDefined) {p.onKeyUp = onKeyUp.map(v => (e: ReactKeyboardEvent) => v(e).runNow())}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (tabIndex.isDefined) {p.tabIndex = tabIndex}
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
    
    jsComponent(p)
  }

}
        