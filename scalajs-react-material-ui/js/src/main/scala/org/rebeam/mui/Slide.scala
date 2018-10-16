
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Slide {
  
  sealed trait Direction{ val value: String }

  object Direction {
    case object Left extends Direction { val value: String = "left" }
    case object Right extends Direction { val value: String = "right" }
    case object Up extends Direction { val value: String = "up" }
    case object Down extends Direction { val value: String = "down" }
  }
          
  @js.native
  trait Props extends js.Object {
    var direction: js.UndefOr[String] = js.native
    var in: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var onEnter: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onEntering: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onExit: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onExited: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var theme: js.Object = js.native
    var timeout: js.UndefOr[js.Any] = js.native
  }

  @JSImport("@material-ui/core/Slide", JSImport.Default)
  @js.native
  object SlideJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](SlideJS)
  
  /**
   * The Slide transition is used by the [Snackbar](/demos/snackbars/) component.
   * It uses [react-transition-group](https://github.com/reactjs/react-transition-group) internally.
   * @param children
   *        A single child content element.
   * @param direction
   *        Direction the child node will enter from.
   * @param in
   *        If `true`, show the component; triggers the enter or exit animation.
   * @param key
   *        React key
   * @param onEnter
   *        Property spread to root element
   * @param onEntering
   *        Property spread to root element
   * @param onExit
   *        Property spread to root element
   * @param onExited
   *        Property spread to root element
   * @param style
   *        Property spread to root element
   * @param theme
   *        Property spread to root element
   * @param timeout
   *        The duration for the transition, in milliseconds.
   *        You may specify a single timeout for all transitions, or individually with an object.
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
    direction: js.UndefOr[Direction] = js.undefined,
    in: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onEnter: js.UndefOr[Callback] = js.undefined,
    onEntering: js.UndefOr[Callback] = js.undefined,
    onExit: js.UndefOr[Callback] = js.undefined,
    onExited: js.UndefOr[Callback] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    theme: js.Object,
    timeout: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (direction.isDefined) {p.direction = direction.map(v => v.value)}
    if (in.isDefined) {p.in = in}
    if (key.isDefined) {p.key = key}
    if (onEnter.isDefined) {p.onEnter = onEnter.map(v => v.toJsFn)}
    if (onEntering.isDefined) {p.onEntering = onEntering.map(v => v.toJsFn)}
    if (onExit.isDefined) {p.onExit = onExit.map(v => v.toJsFn)}
    if (onExited.isDefined) {p.onExited = onExited.map(v => v.toJsFn)}
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
        