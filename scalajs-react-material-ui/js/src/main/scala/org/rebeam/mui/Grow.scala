
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Grow {
  
  @js.native
  trait Props extends js.Object {
    var in: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var onEnter: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onExit: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var theme: js.Object = js.native
    var timeout: js.UndefOr[js.Any] = js.native
  }

  @JSImport("@material-ui/core/Grow", JSImport.Default)
  @js.native
  object GrowJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](GrowJS)
  
  /**
   * The Grow transition is used by the [Tooltip](/demos/tooltips/) and
   * [Popover](/utils/popover/) components.
   * It uses [react-transition-group](https://github.com/reactjs/react-transition-group) internally.
   * @param children
   *        A single child content element.
   * @param in
   *        If `true`, show the component; triggers the enter or exit animation.
   * @param key
   *        React key
   * @param onEnter
   *        Property spread to root element
   * @param onExit
   *        Property spread to root element
   * @param style
   *        Property spread to root element
   * @param theme
   *        Property spread to root element
   * @param timeout
   *        The duration for the transition, in milliseconds.
   *        You may specify a single timeout for all transitions, or individually with an object.
   *        
   *        Set to 'auto' to automatically calculate transition time based on height.
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
    in: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onEnter: js.UndefOr[Callback] = js.undefined,
    onExit: js.UndefOr[Callback] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    theme: js.Object,
    timeout: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (in.isDefined) {p.in = in}
    if (key.isDefined) {p.key = key}
    if (onEnter.isDefined) {p.onEnter = onEnter.map(v => v.toJsFn)}
    if (onExit.isDefined) {p.onExit = onExit.map(v => v.toJsFn)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    p.theme = theme
    if (timeout.isDefined) {p.timeout = timeout}

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
        