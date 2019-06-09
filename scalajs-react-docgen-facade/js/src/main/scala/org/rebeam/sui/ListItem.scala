
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object ListItem {
  
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var description: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var header: js.UndefOr[js.Any] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var image: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var value: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "ListItem")
  @js.native
  object ListItemJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](ListItemJS)
  
  /**
   * A list item can contain a set of items.
   * @param active
   *        A list item can active.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   *        
   *        Heads up!
   *        
   *        This is handled slightly differently than the typical `content` prop since
   *        the wrapping ListContent is not used when there's no icon or image.
   *        
   *        If you pass content as:
   *        - an element/literal, it's treated as the sibling node to
   *        header/description (whether wrapped in Item.Content or not).
   *        - a props object, it forces the presence of Item.Content and passes those
   *        props to it. If you pass a content prop within that props object, it
   *        will be treated as the sibling node to header/description.
   * @param description
   *        Shorthand for ListDescription.
   * @param disabled
   *        A list item can disabled.
   * @param header
   *        Shorthand for ListHeader.
   * @param icon
   *        Shorthand for ListIcon.
   * @param image
   *        Shorthand for Image.
   * @param key
   *        React key
   * @param onClick
   *        A ListItem can be clicked
   * @param style
   *        React element CSS style
   * @param value
   *        A value for an ordered list.
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
    header: js.UndefOr[js.Any] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    image: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    value: js.UndefOr[String] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (description.isDefined) {p.description = description}
    if (disabled.isDefined) {p.disabled = disabled}
    if (header.isDefined) {p.header = header}
    if (icon.isDefined) {p.icon = icon}
    if (image.isDefined) {p.image = image}
    if (key.isDefined) {p.key = key}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (style.isDefined) {p.style = style.map(v => v.o)}
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
        