
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Portal {
  
  @js.native
  trait Props extends js.Object {
    var closeOnDocumentClick: js.UndefOr[Boolean] = js.native
    var closeOnEscape: js.UndefOr[Boolean] = js.native
    var closeOnPortalMouseLeave: js.UndefOr[Boolean] = js.native
    var closeOnTriggerBlur: js.UndefOr[Boolean] = js.native
    var closeOnTriggerClick: js.UndefOr[Boolean] = js.native
    var closeOnTriggerMouseLeave: js.UndefOr[Boolean] = js.native
    var defaultOpen: js.UndefOr[Boolean] = js.native
    var eventPool: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var mountNode: js.UndefOr[js.Any] = js.native
    var mouseEnterDelay: js.UndefOr[Double] = js.native
    var mouseLeaveDelay: js.UndefOr[Double] = js.native
    var onClose: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onMount: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onOpen: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onUnmount: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var open: js.UndefOr[Boolean] = js.native
    var openOnTriggerClick: js.UndefOr[Boolean] = js.native
    var openOnTriggerFocus: js.UndefOr[Boolean] = js.native
    var openOnTriggerMouseEnter: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var trigger: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var triggerRef: js.UndefOr[js.Any] = js.native
  }

  @JSImport("semantic-ui-react", "Portal")
  @js.native
  object PortalJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](PortalJS)
  
  /**
   * A component that allows you to render children outside their parent.
   * @see Modal
   * @see Popup
   * @see Dimmer
   * @see Confirm
   * @param children
   *        Primary content.
   * @param closeOnDocumentClick
   *        Controls whether or not the portal should close when the document is clicked.
   * @param closeOnEscape
   *        Controls whether or not the portal should close when escape is pressed is displayed.
   * @param closeOnPortalMouseLeave
   *        Controls whether or not the portal should close when mousing out of the portal.
   *        NOTE: This will prevent `closeOnTriggerMouseLeave` when mousing over the
   *        gap from the trigger to the portal.
   * @param closeOnTriggerBlur
   *        Controls whether or not the portal should close on blur of the trigger.
   * @param closeOnTriggerClick
   *        Controls whether or not the portal should close on click of the trigger.
   * @param closeOnTriggerMouseLeave
   *        Controls whether or not the portal should close when mousing out of the trigger.
   * @param defaultOpen
   *        Initial value of open.
   * @param eventPool
   *        Event pool namespace that is used to handle component events
   * @param key
   *        React key
   * @param mountNode
   *        The node where the portal should mount.
   * @param mouseEnterDelay
   *        Milliseconds to wait before opening on mouse over
   * @param mouseLeaveDelay
   *        Milliseconds to wait before closing on mouse leave
   * @param onClose
   *        Called when a close event happens
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param onMount
   *        Called when the portal is mounted on the DOM.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onOpen
   *        Called when an open event happens
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param onUnmount
   *        Called when the portal is unmounted from the DOM.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param open
   *        Controls whether or not the portal is displayed.
   * @param openOnTriggerClick
   *        Controls whether or not the portal should open when the trigger is clicked.
   * @param openOnTriggerFocus
   *        Controls whether or not the portal should open on focus of the trigger.
   * @param openOnTriggerMouseEnter
   *        Controls whether or not the portal should open when mousing over the trigger.
   * @param style
   *        React element CSS style
   * @param trigger
   *        Element to be rendered in-place where the portal is defined.
   * @param triggerRef
   *        Called with a ref to the trigger node.
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
    closeOnDocumentClick: js.UndefOr[Boolean] = js.undefined,
    closeOnEscape: js.UndefOr[Boolean] = js.undefined,
    closeOnPortalMouseLeave: js.UndefOr[Boolean] = js.undefined,
    closeOnTriggerBlur: js.UndefOr[Boolean] = js.undefined,
    closeOnTriggerClick: js.UndefOr[Boolean] = js.undefined,
    closeOnTriggerMouseLeave: js.UndefOr[Boolean] = js.undefined,
    defaultOpen: js.UndefOr[Boolean] = js.undefined,
    eventPool: js.UndefOr[String] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    mountNode: js.UndefOr[js.Any] = js.undefined,
    mouseEnterDelay: js.UndefOr[Double] = js.undefined,
    mouseLeaveDelay: js.UndefOr[Double] = js.undefined,
    onClose: js.UndefOr[Callback] = js.undefined,
    onMount: js.UndefOr[Callback] = js.undefined,
    onOpen: js.UndefOr[Callback] = js.undefined,
    onUnmount: js.UndefOr[Callback] = js.undefined,
    open: js.UndefOr[Boolean] = js.undefined,
    openOnTriggerClick: js.UndefOr[Boolean] = js.undefined,
    openOnTriggerFocus: js.UndefOr[Boolean] = js.undefined,
    openOnTriggerMouseEnter: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    trigger: js.UndefOr[VdomNode] = js.undefined,
    triggerRef: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (closeOnDocumentClick.isDefined) {p.closeOnDocumentClick = closeOnDocumentClick}
    if (closeOnEscape.isDefined) {p.closeOnEscape = closeOnEscape}
    if (closeOnPortalMouseLeave.isDefined) {p.closeOnPortalMouseLeave = closeOnPortalMouseLeave}
    if (closeOnTriggerBlur.isDefined) {p.closeOnTriggerBlur = closeOnTriggerBlur}
    if (closeOnTriggerClick.isDefined) {p.closeOnTriggerClick = closeOnTriggerClick}
    if (closeOnTriggerMouseLeave.isDefined) {p.closeOnTriggerMouseLeave = closeOnTriggerMouseLeave}
    if (defaultOpen.isDefined) {p.defaultOpen = defaultOpen}
    if (eventPool.isDefined) {p.eventPool = eventPool}
    if (key.isDefined) {p.key = key}
    if (mountNode.isDefined) {p.mountNode = mountNode}
    if (mouseEnterDelay.isDefined) {p.mouseEnterDelay = mouseEnterDelay}
    if (mouseLeaveDelay.isDefined) {p.mouseLeaveDelay = mouseLeaveDelay}
    if (onClose.isDefined) {p.onClose = onClose.map(v => v.toJsFn)}
    if (onMount.isDefined) {p.onMount = onMount.map(v => v.toJsFn)}
    if (onOpen.isDefined) {p.onOpen = onOpen.map(v => v.toJsFn)}
    if (onUnmount.isDefined) {p.onUnmount = onUnmount.map(v => v.toJsFn)}
    if (open.isDefined) {p.open = open}
    if (openOnTriggerClick.isDefined) {p.openOnTriggerClick = openOnTriggerClick}
    if (openOnTriggerFocus.isDefined) {p.openOnTriggerFocus = openOnTriggerFocus}
    if (openOnTriggerMouseEnter.isDefined) {p.openOnTriggerMouseEnter = openOnTriggerMouseEnter}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (trigger.isDefined) {p.trigger = trigger.map(v => v.rawNode)}
    if (triggerRef.isDefined) {p.triggerRef = triggerRef}

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
        