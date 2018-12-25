
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Tooltip {
  
  sealed trait Placement{ val value: String }

  object Placement {
    case object BottomStart extends Placement { val value: String = "bottom-start" }
    case object LeftEnd extends Placement { val value: String = "left-end" }
    case object TopEnd extends Placement { val value: String = "top-end" }
    case object BottomEnd extends Placement { val value: String = "bottom-end" }
    case object Top extends Placement { val value: String = "top" }
    case object RightEnd extends Placement { val value: String = "right-end" }
    case object LeftStart extends Placement { val value: String = "left-start" }
    case object Right extends Placement { val value: String = "right" }
    case object TopStart extends Placement { val value: String = "top-start" }
    case object Bottom extends Placement { val value: String = "bottom" }
    case object Left extends Placement { val value: String = "left" }
    case object RightStart extends Placement { val value: String = "right-start" }
  }
          
  @js.native
  trait Props extends js.Object {
    var PopperProps: js.UndefOr[js.Object] = js.native
    var TransitionComponent: js.UndefOr[js.Any] = js.native
    var TransitionProps: js.UndefOr[js.Object] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var disableFocusListener: js.UndefOr[Boolean] = js.native
    var disableHoverListener: js.UndefOr[Boolean] = js.native
    var disableTouchListener: js.UndefOr[Boolean] = js.native
    var enterDelay: js.UndefOr[Double] = js.native
    var enterTouchDelay: js.UndefOr[Double] = js.native
    var id: js.UndefOr[String] = js.native
    var interactive: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var leaveDelay: js.UndefOr[Double] = js.native
    var leaveTouchDelay: js.UndefOr[Double] = js.native
    var onClose: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onOpen: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var open: js.UndefOr[Boolean] = js.native
    var placement: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var theme: js.Object = js.native
    var title: japgolly.scalajs.react.raw.React.Node = js.native
  }

  @JSImport("@material-ui/core/Tooltip", JSImport.Default)
  @js.native
  object TooltipJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](TooltipJS)
  
  /**
   * 
   * @param PopperProps
   *        Properties applied to the [`Popper`](/api/popper/) element.
   * @param TransitionComponent
   *        The component used for the transition.
   * @param TransitionProps
   *        Properties applied to the `Transition` element.
   * @param children
   *        Tooltip reference element.
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param disableFocusListener
   *        Do not respond to focus events.
   * @param disableHoverListener
   *        Do not respond to hover events.
   * @param disableTouchListener
   *        Do not respond to long press touch events.
   * @param enterDelay
   *        The number of milliseconds to wait before showing the tooltip.
   *        This property won't impact the enter touch delay (`enterTouchDelay`).
   * @param enterTouchDelay
   *        The number of milliseconds a user must touch the element before showing the tooltip.
   * @param id
   *        The relationship between the tooltip and the wrapper component is not clear from the DOM.
   *        This property is used with aria-describedby to solve the accessibility issue.
   *        If you don't provide this property. It falls back to a randomly generated id.
   * @param interactive
   *        Makes a tooltip interactive, i.e. will not close when the user
   *        hovers over the tooltip before the `leaveDelay` is expired.
   * @param key
   *        React key
   * @param leaveDelay
   *        The number of milliseconds to wait before hiding the tooltip.
   *        This property won't impact the leave touch delay (`leaveTouchDelay`).
   * @param leaveTouchDelay
   *        The number of milliseconds after the user stops touching an element before hiding the tooltip.
   * @param onClose
   *        Callback fired when the tooltip requests to be closed.
   *        
   *        parameter {object} event The event source of the callback
   * @param onOpen
   *        Callback fired when the tooltip requests to be open.
   *        
   *        parameter {object} event The event source of the callback
   * @param open
   *        If `true`, the tooltip is shown.
   * @param placement
   *        Tooltip placement.
   * @param style
   *        React element CSS style
   * @param theme
   *        Property spread to root element
   * @param title
   *        Tooltip title. Zero-length titles string are never displayed.
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
    PopperProps: js.UndefOr[js.Object] = js.undefined,
    TransitionComponent: js.UndefOr[js.Any] = js.undefined,
    TransitionProps: js.UndefOr[js.Object] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    disableFocusListener: js.UndefOr[Boolean] = js.undefined,
    disableHoverListener: js.UndefOr[Boolean] = js.undefined,
    disableTouchListener: js.UndefOr[Boolean] = js.undefined,
    enterDelay: js.UndefOr[Double] = js.undefined,
    enterTouchDelay: js.UndefOr[Double] = js.undefined,
    id: js.UndefOr[String] = js.undefined,
    interactive: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    leaveDelay: js.UndefOr[Double] = js.undefined,
    leaveTouchDelay: js.UndefOr[Double] = js.undefined,
    onClose: js.UndefOr[Callback] = js.undefined,
    onOpen: js.UndefOr[Callback] = js.undefined,
    open: js.UndefOr[Boolean] = js.undefined,
    placement: js.UndefOr[Placement] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    theme: js.Object,
    title: VdomNode,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (PopperProps.isDefined) {p.PopperProps = PopperProps}
    if (TransitionComponent.isDefined) {p.TransitionComponent = TransitionComponent}
    if (TransitionProps.isDefined) {p.TransitionProps = TransitionProps}
    if (classes.isDefined) {p.classes = classes}
    if (disableFocusListener.isDefined) {p.disableFocusListener = disableFocusListener}
    if (disableHoverListener.isDefined) {p.disableHoverListener = disableHoverListener}
    if (disableTouchListener.isDefined) {p.disableTouchListener = disableTouchListener}
    if (enterDelay.isDefined) {p.enterDelay = enterDelay}
    if (enterTouchDelay.isDefined) {p.enterTouchDelay = enterTouchDelay}
    if (id.isDefined) {p.id = id}
    if (interactive.isDefined) {p.interactive = interactive}
    if (key.isDefined) {p.key = key}
    if (leaveDelay.isDefined) {p.leaveDelay = leaveDelay}
    if (leaveTouchDelay.isDefined) {p.leaveTouchDelay = leaveTouchDelay}
    if (onClose.isDefined) {p.onClose = onClose.map(v => v.toJsFn)}
    if (onOpen.isDefined) {p.onOpen = onOpen.map(v => v.toJsFn)}
    if (open.isDefined) {p.open = open}
    if (placement.isDefined) {p.placement = placement.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    p.theme = theme
    p.title = title.rawNode

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
        