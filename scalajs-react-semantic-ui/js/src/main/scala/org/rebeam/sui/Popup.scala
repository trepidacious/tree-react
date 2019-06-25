
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Popup {
  
  sealed trait Position{ val value: String }

  object Position {
    case object LeftCenter extends Position { val value: String = "left center" }
    case object BottomLeft extends Position { val value: String = "bottom left" }
    case object BottomRight extends Position { val value: String = "bottom right" }
    case object BottomCenter extends Position { val value: String = "bottom center" }
    case object TopRight extends Position { val value: String = "top right" }
    case object RightCenter extends Position { val value: String = "right center" }
    case object TopCenter extends Position { val value: String = "top center" }
    case object TopLeft extends Position { val value: String = "top left" }
  }
            
  sealed trait Size{ val value: String }

  object Size {
    case object Mini extends Size { val value: String = "mini" }
    case object Tiny extends Size { val value: String = "tiny" }
    case object Small extends Size { val value: String = "small" }
    case object Huge extends Size { val value: String = "huge" }
    case object Large extends Size { val value: String = "large" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var basic: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var context: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var flowing: js.UndefOr[Boolean] = js.native
    var header: js.UndefOr[js.Any] = js.native
    var hideOnScroll: js.UndefOr[Boolean] = js.native
    var hoverable: js.UndefOr[Boolean] = js.native
    var inverted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var offset: js.UndefOr[js.Any] = js.native
    var on: js.UndefOr[js.Any] = js.native
    var onClose: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onMount: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onOpen: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onUnmount: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var position: js.UndefOr[String] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var trigger: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var wide: js.UndefOr[js.Any] = js.native
  }

  @JSImport("semantic-ui-react", "Popup")
  @js.native
  object PopupJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](PopupJS)
  
  /**
   * A Popup displays additional information on top of a page.
   * @param as
   *        An element type to render as (string or function).
   * @param basic
   *        Display the popup without the pointing arrow.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Simple text content for the popover.
   * @param context
   *        Existing element the pop-up should be bound to.
   * @param disabled
   *        A disabled popup only renders its trigger.
   * @param flowing
   *        A flowing Popup has no maximum width and continues to flow to fit its content.
   * @param header
   *        Header displayed above the content in bold.
   * @param hideOnScroll
   *        Hide the Popup when scrolling the window.
   * @param hoverable
   *        Whether the popup should not close on hover.
   * @param inverted
   *        Invert the colors of the Popup.
   * @param key
   *        React key
   * @param offset
   *        Offset value to apply to rendered popup. Accepts the following units:
   *        - px or unit-less, interpreted as pixels
   *        - %, percentage relative to the length of the trigger element
   *        - %p, percentage relative to the length of the popup element
   *        - vw, CSS viewport width unit
   *        - vh, CSS viewport height unit
   * @param on
   *        Events triggering the popup.
   * @param onClose
   *        Called when a close event happens.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param onMount
   *        Called when the portal is mounted on the DOM.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onOpen
   *        Called when an open event happens.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param onUnmount
   *        Called when the portal is unmounted from the DOM.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param position
   *        Position for the popover.
   * @param size
   *        Popup size.
   * @param style
   *        Custom Popup style.
   * @param trigger
   *        Element to be rendered in-place where the popup is defined.
   * @param wide
   *        Popup width.
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
    basic: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    context: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    flowing: js.UndefOr[Boolean] = js.undefined,
    header: js.UndefOr[js.Any] = js.undefined,
    hideOnScroll: js.UndefOr[Boolean] = js.undefined,
    hoverable: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    offset: js.UndefOr[js.Any] = js.undefined,
    on: js.UndefOr[js.Any] = js.undefined,
    onClose: js.UndefOr[Callback] = js.undefined,
    onMount: js.UndefOr[Callback] = js.undefined,
    onOpen: js.UndefOr[Callback] = js.undefined,
    onUnmount: js.UndefOr[Callback] = js.undefined,
    position: js.UndefOr[Position] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    trigger: js.UndefOr[VdomNode] = js.undefined,
    wide: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (basic.isDefined) {p.basic = basic}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (context.isDefined) {p.context = context}
    if (disabled.isDefined) {p.disabled = disabled}
    if (flowing.isDefined) {p.flowing = flowing}
    if (header.isDefined) {p.header = header}
    if (hideOnScroll.isDefined) {p.hideOnScroll = hideOnScroll}
    if (hoverable.isDefined) {p.hoverable = hoverable}
    if (inverted.isDefined) {p.inverted = inverted}
    if (key.isDefined) {p.key = key}
    if (offset.isDefined) {p.offset = offset}
    if (on.isDefined) {p.on = on}
    if (onClose.isDefined) {p.onClose = onClose.map(v => v.toJsFn)}
    if (onMount.isDefined) {p.onMount = onMount.map(v => v.toJsFn)}
    if (onOpen.isDefined) {p.onOpen = onOpen.map(v => v.toJsFn)}
    if (onUnmount.isDefined) {p.onUnmount = onUnmount.map(v => v.toJsFn)}
    if (position.isDefined) {p.position = position.map(v => v.value)}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (trigger.isDefined) {p.trigger = trigger.map(v => v.rawNode)}
    if (wide.isDefined) {p.wide = wide}

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
        