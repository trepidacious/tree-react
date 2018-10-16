
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Collapse {
  
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var collapsedHeight: js.UndefOr[String] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var in: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var onEnter: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onEntered: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onEntering: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onExit: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onExiting: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var theme: js.Object = js.native
    var timeout: js.UndefOr[js.Any] = js.native
  }

  @JSImport("@material-ui/core/Collapse", JSImport.Default)
  @js.native
  object CollapseJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](CollapseJS)
  
  /**
   * The Collapse transition is used by the
   * [Vertical Stepper](/demos/steppers/#vertical-stepper) StepContent component.
   * It uses [react-transition-group](https://github.com/reactjs/react-transition-group) internally.
   * @param children
   *        The content node to be collapsed.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param collapsedHeight
   *        The height of the container when collapsed.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param in
   *        If `true`, the component will transition in.
   * @param key
   *        React key
   * @param onEnter
   *        Property spread to root element
   * @param onEntered
   *        Property spread to root element
   * @param onEntering
   *        Property spread to root element
   * @param onExit
   *        Property spread to root element
   * @param onExiting
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
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    collapsedHeight: js.UndefOr[String] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    in: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onEnter: js.UndefOr[Callback] = js.undefined,
    onEntered: js.UndefOr[Callback] = js.undefined,
    onEntering: js.UndefOr[Callback] = js.undefined,
    onExit: js.UndefOr[Callback] = js.undefined,
    onExiting: js.UndefOr[Callback] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    theme: js.Object,
    timeout: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (collapsedHeight.isDefined) {p.collapsedHeight = collapsedHeight}
    if (component.isDefined) {p.component = component}
    if (in.isDefined) {p.in = in}
    if (key.isDefined) {p.key = key}
    if (onEnter.isDefined) {p.onEnter = onEnter.map(v => v.toJsFn)}
    if (onEntered.isDefined) {p.onEntered = onEntered.map(v => v.toJsFn)}
    if (onEntering.isDefined) {p.onEntering = onEntering.map(v => v.toJsFn)}
    if (onExit.isDefined) {p.onExit = onExit.map(v => v.toJsFn)}
    if (onExiting.isDefined) {p.onExiting = onExiting.map(v => v.toJsFn)}
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
        