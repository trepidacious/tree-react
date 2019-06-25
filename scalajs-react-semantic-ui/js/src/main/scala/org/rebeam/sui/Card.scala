
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Card {
  
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
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var centered: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var color: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var description: js.UndefOr[js.Any] = js.native
    var extra: js.UndefOr[js.Any] = js.native
    var fluid: js.UndefOr[Boolean] = js.native
    var header: js.UndefOr[js.Any] = js.native
    var href: js.UndefOr[String] = js.native
    var image: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var link: js.UndefOr[Boolean] = js.native
    var meta: js.UndefOr[js.Any] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var raised: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "Card")
  @js.native
  object CardJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](CardJS)
  
  /**
   * A card displays site content in a manner similar to a playing card.
   * @param as
   *        An element type to render as (string or function).
   * @param centered
   *        A Card can center itself inside its container.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param color
   *        A Card can be formatted to display different colors.
   * @param content
   *        Shorthand for primary content.
   * @param description
   *        Shorthand for CardDescription.
   * @param extra
   *        Shorthand for primary content of CardContent.
   * @param fluid
   *        A Card can be formatted to take up the width of its container.
   * @param header
   *        Shorthand for CardHeader.
   * @param href
   *        Render as an `a` tag instead of a `div` and adds the href attribute.
   * @param image
   *        A card can contain an Image component.
   * @param key
   *        React key
   * @param link
   *        A card can be formatted to link to other content.
   * @param meta
   *        Shorthand for CardMeta.
   * @param onClick
   *        Called on click. When passed, the component renders as an `a`
   *        tag by default instead of a `div`.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param raised
   *        A Card can be formatted to raise above the page.
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
    as: js.UndefOr[String] = js.undefined,
    centered: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    description: js.UndefOr[js.Any] = js.undefined,
    extra: js.UndefOr[js.Any] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    header: js.UndefOr[js.Any] = js.undefined,
    href: js.UndefOr[String] = js.undefined,
    image: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    link: js.UndefOr[Boolean] = js.undefined,
    meta: js.UndefOr[js.Any] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    raised: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (centered.isDefined) {p.centered = centered}
    if (className.isDefined) {p.className = className}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (content.isDefined) {p.content = content}
    if (description.isDefined) {p.description = description}
    if (extra.isDefined) {p.extra = extra}
    if (fluid.isDefined) {p.fluid = fluid}
    if (header.isDefined) {p.header = header}
    if (href.isDefined) {p.href = href}
    if (image.isDefined) {p.image = image}
    if (key.isDefined) {p.key = key}
    if (link.isDefined) {p.link = link}
    if (meta.isDefined) {p.meta = meta}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (raised.isDefined) {p.raised = raised}
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
        