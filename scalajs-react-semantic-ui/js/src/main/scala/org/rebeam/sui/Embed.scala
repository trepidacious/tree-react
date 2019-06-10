
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Embed {
  
  sealed trait AspectRatio{ val value: String }

  object AspectRatio {
    case object _4_3 extends AspectRatio { val value: String = "4:3" }
    case object _16_9 extends AspectRatio { val value: String = "16:9" }
    case object _21_9 extends AspectRatio { val value: String = "21:9" }
  }
          
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[js.Any] = js.native
    var aspectRatio: js.UndefOr[String] = js.native
    var autoplay: js.UndefOr[js.Any] = js.native
    var brandedUI: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var color: js.UndefOr[js.Any] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var defaultActive: js.UndefOr[Boolean] = js.native
    var hd: js.UndefOr[js.Any] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var id: js.UndefOr[js.Any] = js.native
    var iframe: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var placeholder: js.UndefOr[String] = js.native
    var source: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var url: js.UndefOr[js.Any] = js.native
  }

  @JSImport("semantic-ui-react", "Embed")
  @js.native
  object EmbedJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](EmbedJS)
  
  /**
   * An embed displays content from other websites like YouTube videos or Google Maps.
   * @param active
   *        An embed can be active.
   * @param as
   *        An element type to render as (string or function).
   * @param aspectRatio
   *        An embed can specify an alternative aspect ratio.
   * @param autoplay
   *        Setting to true or false will force autoplay.
   * @param brandedUI
   *        Whether to show networks branded UI like title cards, or after video calls to action.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param color
   *        Specifies a default chrome color with Vimeo or YouTube.
   * @param content
   *        Shorthand for primary content.
   * @param defaultActive
   *        Initial value of active.
   * @param hd
   *        Whether to prefer HD content.
   * @param icon
   *        Specifies an icon to use with placeholder content.
   * @param id
   *        Specifies an id for source.
   * @param iframe
   *        Shorthand for HTML iframe.
   * @param key
   *        React key
   * @param onClick
   *        Сalled on click.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props and proposed value.
   * @param placeholder
   *        A placeholder image for embed.
   * @param source
   *        Specifies a source to use.
   * @param style
   *        React element CSS style
   * @param url
   *        Specifies a url to use for embed.
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
    aspectRatio: js.UndefOr[AspectRatio] = js.undefined,
    autoplay: js.UndefOr[js.Any] = js.undefined,
    brandedUI: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    color: js.UndefOr[js.Any] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    defaultActive: js.UndefOr[Boolean] = js.undefined,
    hd: js.UndefOr[js.Any] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    id: js.UndefOr[js.Any] = js.undefined,
    iframe: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    placeholder: js.UndefOr[String] = js.undefined,
    source: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    url: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (as.isDefined) {p.as = as}
    if (aspectRatio.isDefined) {p.aspectRatio = aspectRatio.map(v => v.value)}
    if (autoplay.isDefined) {p.autoplay = autoplay}
    if (brandedUI.isDefined) {p.brandedUI = brandedUI}
    if (className.isDefined) {p.className = className}
    if (color.isDefined) {p.color = color}
    if (content.isDefined) {p.content = content}
    if (defaultActive.isDefined) {p.defaultActive = defaultActive}
    if (hd.isDefined) {p.hd = hd}
    if (icon.isDefined) {p.icon = icon}
    if (id.isDefined) {p.id = id}
    if (iframe.isDefined) {p.iframe = iframe}
    if (key.isDefined) {p.key = key}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (placeholder.isDefined) {p.placeholder = placeholder}
    if (source.isDefined) {p.source = source}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (url.isDefined) {p.url = url}

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
        