
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Fade {
  
  @js.native
  trait Props extends js.Object {
    var appear: js.UndefOr[Boolean] = js.native
    var enter: js.UndefOr[Boolean] = js.native
    var exit: js.UndefOr[Boolean] = js.native
    var in: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var mountOnEnter: js.UndefOr[Boolean] = js.native
    var onEnter: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onExit: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var theme: js.Object = js.native
    var timeout: js.UndefOr[js.Any] = js.native
    var unmountOnExit: js.UndefOr[Boolean] = js.native
  }

  @JSImport("@material-ui/core/Fade", JSImport.Default)
  @js.native
  object FadeJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](FadeJS)
  
  /**
   * The Fade transition is used by the [Modal](/utils/modal/) component.
   * It uses [react-transition-group](https://github.com/reactjs/react-transition-group) internally.
   * @param appear
   *        Normally a component is not transitioned if it is shown when the &lt;Transition&gt; component mounts. If you want to transition on the first mount set appear to true, and the component will transition in as soon as the &lt;Transition&gt; mounts.
   *        
   *        Note: there are no specific "appear" states. appear only adds an additional enter transition.
   *        Passed to Transition
   * @param children
   *        A single child content element.
   * @param enter
   *        Enable or disable enter transitions.
   *        Passed to Transition
   * @param exit
   *        Enable or disable exit transitions.
   *        Passed to Transition
   * @param in
   *        If `true`, the component will transition in.
   * @param key
   *        React key
   * @param mountOnEnter
   *        By default the child component is mounted immediately along with the parent Transition component. If you want to "lazy mount" the component on the first in={true} you can set mountOnEnter. After the first enter transition the component will stay mounted, even on "exited", unless you also specify unmountOnExit.
   *        Passed to Transition
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
   * @param unmountOnExit
   *        By default the child component stays mounted after it reaches the 'exited' state. Set unmountOnExit if you'd prefer to unmount the component after it finishes exiting.
   *        Passed to Transition
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
    appear: js.UndefOr[Boolean] = js.undefined,
    enter: js.UndefOr[Boolean] = js.undefined,
    exit: js.UndefOr[Boolean] = js.undefined,
    in: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    mountOnEnter: js.UndefOr[Boolean] = js.undefined,
    onEnter: js.UndefOr[Callback] = js.undefined,
    onExit: js.UndefOr[Callback] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    theme: js.Object,
    timeout: js.UndefOr[js.Any] = js.undefined,
    unmountOnExit: js.UndefOr[Boolean] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (appear.isDefined) {p.appear = appear}
    if (enter.isDefined) {p.enter = enter}
    if (exit.isDefined) {p.exit = exit}
    if (in.isDefined) {p.in = in}
    if (key.isDefined) {p.key = key}
    if (mountOnEnter.isDefined) {p.mountOnEnter = mountOnEnter}
    if (onEnter.isDefined) {p.onEnter = onEnter.map(v => v.toJsFn)}
    if (onExit.isDefined) {p.onExit = onExit.map(v => v.toJsFn)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    p.theme = theme
    if (timeout.isDefined) {p.timeout = timeout}
    if (unmountOnExit.isDefined) {p.unmountOnExit = unmountOnExit}

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
        