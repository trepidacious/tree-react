
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object FeedEvent {
  
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var date: js.UndefOr[js.Any] = js.native
    var extraImages: js.UndefOr[js.Any] = js.native
    var extraText: js.UndefOr[js.Any] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var image: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var meta: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var summary: js.UndefOr[js.Any] = js.native
  }

  @JSImport("semantic-ui-react", "FeedEvent")
  @js.native
  object FeedEventJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](FeedEventJS)
  
  /**
   * A feed contains an event.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for FeedContent.
   * @param date
   *        Shorthand for FeedDate.
   * @param extraImages
   *        Shorthand for FeedExtra with images.
   * @param extraText
   *        Shorthand for FeedExtra with content.
   * @param icon
   *        An event can contain icon label.
   * @param image
   *        An event can contain image label.
   * @param key
   *        React key
   * @param meta
   *        Shorthand for FeedMeta.
   * @param style
   *        React element CSS style
   * @param summary
   *        Shorthand for FeedSummary.
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
    date: js.UndefOr[js.Any] = js.undefined,
    extraImages: js.UndefOr[js.Any] = js.undefined,
    extraText: js.UndefOr[js.Any] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    image: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    meta: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    summary: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (date.isDefined) {p.date = date}
    if (extraImages.isDefined) {p.extraImages = extraImages}
    if (extraText.isDefined) {p.extraText = extraText}
    if (icon.isDefined) {p.icon = icon}
    if (image.isDefined) {p.image = image}
    if (key.isDefined) {p.key = key}
    if (meta.isDefined) {p.meta = meta}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (summary.isDefined) {p.summary = summary}

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
        