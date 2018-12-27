
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object ClickAwayListener {
  
  sealed trait MouseEvent{ val value: String }

  object MouseEvent {
    case object OnClick extends MouseEvent { val value: String = "onClick" }
    case object OnMouseDown extends MouseEvent { val value: String = "onMouseDown" }
    case object OnMouseUp extends MouseEvent { val value: String = "onMouseUp" }
    case object False extends MouseEvent { val value: String = "false" }
  }
            
  sealed trait TouchEvent{ val value: String }

  object TouchEvent {
    case object OnTouchStart extends TouchEvent { val value: String = "onTouchStart" }
    case object OnTouchEnd extends TouchEvent { val value: String = "onTouchEnd" }
    case object False extends TouchEvent { val value: String = "false" }
  }
          
  @js.native
  trait Props extends js.Object {
    var key: js.UndefOr[String] = js.native
    var mouseEvent: js.UndefOr[String] = js.native
    var onClickAway: scalajs.js.Function0[Unit] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var target: js.Any = js.native
    var touchEvent: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/ClickAwayListener", JSImport.Default)
  @js.native
  object ClickAwayListenerJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](ClickAwayListenerJS)
  
  /**
   * Listen for click events that occur somewhere in the document, outside of the element itself.
   * For instance, if you need to hide a menu when people click anywhere else on your page.
   * @param children
   *        The wrapped element.
   * @param key
   *        React key
   * @param mouseEvent
   *        The mouse event to listen to. You can disable the listener by providing `false`.
   * @param onClickAway
   *        Callback fired when a "click away" event is detected.
   * @param style
   *        React element CSS style
   * @param target
   *        The DOM target to listen to.
   *        Passed to EventListener
   * @param touchEvent
   *        The touch event to listen to. You can disable the listener by providing `false`.
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
    mouseEvent: js.UndefOr[MouseEvent] = js.undefined,
    onClickAway: Callback,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    target: js.Any,
    touchEvent: js.UndefOr[TouchEvent] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (key.isDefined) {p.key = key}
    if (mouseEvent.isDefined) {p.mouseEvent = mouseEvent.map(v => v.value)}
    p.onClickAway = onClickAway.toJsFn
    if (style.isDefined) {p.style = style.map(v => v.o)}
    p.target = target
    if (touchEvent.isDefined) {p.touchEvent = touchEvent.map(v => v.value)}

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
        