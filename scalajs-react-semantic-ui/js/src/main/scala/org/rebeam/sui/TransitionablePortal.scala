
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object TransitionablePortal {
  
  @js.native
  trait Props extends js.Object {
    var key: js.UndefOr[String] = js.native
    var onClose: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onHide: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onOpen: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onStart: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var open: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var transition: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "TransitionablePortal")
  @js.native
  object TransitionablePortalJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](TransitionablePortalJS)
  
  /**
   * A sugar for `Portal` and `Transition`.
   * @see Portal
   * @see Transition
   * @param children
   *        Primary content.
   * @param key
   *        React key
   * @param onClose
   *        Called when a close event happens.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props and internal state.
   * @param onHide
   *        Callback on each transition that changes visibility to hidden.
   *        
   *        parameter {null}
   *        parameter {object} data - All props with transition status and internal state.
   * @param onOpen
   *        Called when an open event happens.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props and internal state.
   * @param onStart
   *        Callback on animation start.
   *        
   *        parameter {null}
   *        parameter {object} data - All props with transition status and internal state.
   * @param open
   *        Controls whether or not the portal is displayed.
   * @param style
   *        React element CSS style
   * @param transition
   *        Transition props.
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
    onClose: js.UndefOr[Callback] = js.undefined,
    onHide: js.UndefOr[Callback] = js.undefined,
    onOpen: js.UndefOr[Callback] = js.undefined,
    onStart: js.UndefOr[Callback] = js.undefined,
    open: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    transition: js.UndefOr[js.Object] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (key.isDefined) {p.key = key}
    if (onClose.isDefined) {p.onClose = onClose.map(v => v.toJsFn)}
    if (onHide.isDefined) {p.onHide = onHide.map(v => v.toJsFn)}
    if (onOpen.isDefined) {p.onOpen = onOpen.map(v => v.toJsFn)}
    if (onStart.isDefined) {p.onStart = onStart.map(v => v.toJsFn)}
    if (open.isDefined) {p.open = open}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (transition.isDefined) {p.transition = transition}

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
        