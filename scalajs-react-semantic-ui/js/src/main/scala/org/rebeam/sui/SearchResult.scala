
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

// import japgolly.scalajs.react.vdom.html_<^._

object SearchResult {
  
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var description: js.UndefOr[String] = js.native
    var id: js.UndefOr[js.Any] = js.native
    var image: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var price: js.UndefOr[String] = js.native
    var renderer: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var title: String = js.native
  }

  @JSImport("semantic-ui-react", "SearchResult")
  @js.native
  object SearchResultJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](SearchResultJS)
  
  /**
   * 
   * @param active
   *        The item currently selected by keyboard shortcut.
   * @param as
   *        An element type to render as (string or function).
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param description
   *        Additional text with less emphasis.
   * @param id
   *        A unique identifier.
   * @param image
   *        Add an image to the item.
   * @param key
   *        React key
   * @param onClick
   *        Called on click.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param price
   *        Customized text for price.
   * @param renderer
   *        Renders the result contents.
   *        
   *        parameter {object} props - The SearchResult props object.
   *        returns {*} - Renderable result contents.
   * @param style
   *        React element CSS style
   * @param title
   *        Display title.
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
    as: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    description: js.UndefOr[String] = js.undefined,
    id: js.UndefOr[js.Any] = js.undefined,
    image: js.UndefOr[String] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    price: js.UndefOr[String] = js.undefined,
    renderer: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    title: String,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (description.isDefined) {p.description = description}
    if (id.isDefined) {p.id = id}
    if (image.isDefined) {p.image = image}
    if (key.isDefined) {p.key = key}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (price.isDefined) {p.price = price}
    if (renderer.isDefined) {p.renderer = renderer}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    p.title = title

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
        