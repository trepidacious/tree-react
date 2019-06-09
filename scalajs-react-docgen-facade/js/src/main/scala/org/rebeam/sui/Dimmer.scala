
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Dimmer {
  
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var page: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "Dimmer")
  @js.native
  object DimmerJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](DimmerJS)
  
  /**
   * A dimmer hides distractions to focus attention on particular content.
   * @param active
   *        An active dimmer will dim its parent container.
   * @param key
   *        React key
   * @param page
   *        A dimmer can be formatted to be fixed to the page.
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
    key: js.UndefOr[String] = js.undefined,
    page: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (key.isDefined) {p.key = key}
    if (page.isDefined) {p.page = page}
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
    
    jsComponent(p)
  }

}
        