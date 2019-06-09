
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object MenuItem {
  
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
            
  sealed trait Position{ val value: String }

  object Position {
    case object Left extends Position { val value: String = "left" }
    case object Right extends Position { val value: String = "right" }
  }
          
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var color: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var fitted: js.UndefOr[js.Any] = js.native
    var header: js.UndefOr[Boolean] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var index: js.UndefOr[Double] = js.native
    var key: js.UndefOr[String] = js.native
    var link: js.UndefOr[Boolean] = js.native
    var name: js.UndefOr[String] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var position: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "MenuItem")
  @js.native
  object MenuItemJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](MenuItemJS)
  
  /**
   * A menu can contain an item.
   * @param active
   *        A menu item can be active.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param color
   *        Additional colors can be specified.
   * @param content
   *        Shorthand for primary content.
   * @param disabled
   *        A menu item can be disabled.
   * @param fitted
   *        A menu item or menu can remove element padding, vertically or horizontally.
   * @param header
   *        A menu item may include a header or may itself be a header.
   * @param icon
   *        MenuItem can be only icon.
   * @param index
   *        MenuItem index inside Menu.
   * @param key
   *        React key
   * @param link
   *        A menu item can be link.
   * @param name
   *        Internal name of the MenuItem.
   * @param onClick
   *        Called on click. When passed, the component will render as an `a`
   *        tag by default instead of a `div`.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param position
   *        A menu item can take left or right position.
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
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    fitted: js.UndefOr[js.Any] = js.undefined,
    header: js.UndefOr[Boolean] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    index: js.UndefOr[Double] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    link: js.UndefOr[Boolean] = js.undefined,
    name: js.UndefOr[String] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    position: js.UndefOr[Position] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (content.isDefined) {p.content = content}
    if (disabled.isDefined) {p.disabled = disabled}
    if (fitted.isDefined) {p.fitted = fitted}
    if (header.isDefined) {p.header = header}
    if (icon.isDefined) {p.icon = icon}
    if (index.isDefined) {p.index = index}
    if (key.isDefined) {p.key = key}
    if (link.isDefined) {p.link = link}
    if (name.isDefined) {p.name = name}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (position.isDefined) {p.position = position.map(v => v.value)}
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
        