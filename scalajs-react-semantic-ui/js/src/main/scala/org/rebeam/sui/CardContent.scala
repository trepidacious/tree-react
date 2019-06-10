
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object CardContent {
  
  sealed trait TextAlign{ val value: String }

  object TextAlign {
    case object Left extends TextAlign { val value: String = "left" }
    case object Center extends TextAlign { val value: String = "center" }
    case object Right extends TextAlign { val value: String = "right" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var description: js.UndefOr[js.Any] = js.native
    var extra: js.UndefOr[Boolean] = js.native
    var header: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var meta: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var textAlign: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "CardContent")
  @js.native
  object CardContentJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](CardContentJS)
  
  /**
   * A card can contain blocks of content or extra content meant to be formatted separately from the main content.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param description
   *        Shorthand for CardDescription.
   * @param extra
   *        A card can contain extra content meant to be formatted separately from the main content.
   * @param header
   *        Shorthand for CardHeader.
   * @param key
   *        React key
   * @param meta
   *        Shorthand for CardMeta.
   * @param style
   *        React element CSS style
   * @param textAlign
   *        A card content can adjust its text alignment.
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
    as: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    description: js.UndefOr[js.Any] = js.undefined,
    extra: js.UndefOr[Boolean] = js.undefined,
    header: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    meta: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    textAlign: js.UndefOr[TextAlign] = js.undefined,
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
    if (textAlign.isDefined) {p.textAlign = textAlign.map(v => v.value)}

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
        