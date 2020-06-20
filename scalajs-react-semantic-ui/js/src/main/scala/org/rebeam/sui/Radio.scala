
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

// import japgolly.scalajs.react.vdom.html_<^._

object Radio {
  
  @js.native
  trait Props extends js.Object {
    var key: js.UndefOr[String] = js.native
    var slider: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var toggle: js.UndefOr[js.Any] = js.native
    var `type`: js.UndefOr[js.Any] = js.native
  }

  @JSImport("semantic-ui-react", "Radio")
  @js.native
  object RadioJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](RadioJS)
  
  /**
   * A Radio is sugar for <Checkbox radio />.
   * Useful for exclusive groups of sliders or toggles.
   * @see Checkbox
   * @see Form
   * @param key
   *        React key
   * @param slider
   *        Format to emphasize the current selection state.
   * @param style
   *        React element CSS style
   * @param toggle
   *        Format to show an on or off choice.
   * @param `type`
   *        HTML input type, either checkbox or radio.
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
    key: js.UndefOr[String] = js.undefined,
    slider: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    toggle: js.UndefOr[js.Any] = js.undefined,
    `type`: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (key.isDefined) {p.key = key}
    if (slider.isDefined) {p.slider = slider}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (toggle.isDefined) {p.toggle = toggle}
    if (`type`.isDefined) {p.`type` = `type`}

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
        