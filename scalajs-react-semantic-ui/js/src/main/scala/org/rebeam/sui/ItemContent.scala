
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object ItemContent {
  
  sealed trait VerticalAlign{ val value: String }

  object VerticalAlign {
    case object Bottom extends VerticalAlign { val value: String = "bottom" }
    case object Middle extends VerticalAlign { val value: String = "middle" }
    case object Top extends VerticalAlign { val value: String = "top" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var description: js.UndefOr[js.Any] = js.native
    var extra: js.UndefOr[js.Any] = js.native
    var header: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var meta: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var verticalAlign: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "ItemContent")
  @js.native
  object ItemContentJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](ItemContentJS)
  
  /**
   * An item can contain content.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param description
   *        Shorthand for ItemDescription component.
   * @param extra
   *        Shorthand for ItemExtra component.
   * @param header
   *        Shorthand for ItemHeader component.
   * @param key
   *        React key
   * @param meta
   *        Shorthand for ItemMeta component.
   * @param style
   *        React element CSS style
   * @param verticalAlign
   *        Content can specify its vertical alignment.
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
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    description: js.UndefOr[js.Any] = js.undefined,
    extra: js.UndefOr[js.Any] = js.undefined,
    header: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    meta: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    verticalAlign: js.UndefOr[VerticalAlign] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (description.isDefined) {p.description = description}
    if (extra.isDefined) {p.extra = extra}
    if (header.isDefined) {p.header = header}
    if (key.isDefined) {p.key = key}
    if (meta.isDefined) {p.meta = meta}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (verticalAlign.isDefined) {p.verticalAlign = verticalAlign.map(v => v.value)}

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
        