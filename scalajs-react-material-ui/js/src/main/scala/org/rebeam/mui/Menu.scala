
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Menu {
  
  sealed trait AnchorReference{ val value: String }

  object AnchorReference {
    case object AnchorEl extends AnchorReference { val value: String = "anchorEl" }
    case object AnchorPosition extends AnchorReference { val value: String = "anchorPosition" }
    case object None extends AnchorReference { val value: String = "none" }
  }
          
  @js.native
  trait Props extends js.Object {
    var BackdropComponent: js.UndefOr[js.Any] = js.native
    var BackdropProps: js.UndefOr[js.Object] = js.native
    var MenuListProps: js.UndefOr[js.Object] = js.native
    var ModalClasses: js.UndefOr[js.Object] = js.native
    var PaperProps: js.UndefOr[js.Object] = js.native
    var PopoverClasses: js.UndefOr[js.Object] = js.native
    var TransitionComponent: js.UndefOr[js.Any] = js.native
    var TransitionProps: js.UndefOr[js.Object] = js.native
    var action: js.UndefOr[js.Any] = js.native
    var anchorEl: js.UndefOr[js.Any] = js.native
    var anchorOrigin: js.UndefOr[js.Any] = js.native
    var anchorPosition: js.UndefOr[js.Any] = js.native
    var anchorReference: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var container: js.UndefOr[js.Any] = js.native
    var disableAutoFocus: js.UndefOr[Boolean] = js.native
    var disableAutoFocusItem: js.UndefOr[Boolean] = js.native
    var disableBackdropClick: js.UndefOr[Boolean] = js.native
    var disableEnforceFocus: js.UndefOr[Boolean] = js.native
    var disableEscapeKeyDown: js.UndefOr[Boolean] = js.native
    var disablePortal: js.UndefOr[Boolean] = js.native
    var disableRestoreFocus: js.UndefOr[Boolean] = js.native
    var elevation: js.UndefOr[Double] = js.native
    var getContentAnchorEl: js.UndefOr[js.Any] = js.native
    var hideBackdrop: js.UndefOr[Boolean] = js.native
    var keepMounted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var manager: js.UndefOr[js.Object] = js.native
    var marginThreshold: js.UndefOr[Double] = js.native
    var onBackdropClick: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onClose: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onEnter: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onEntered: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onEntering: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onEscapeKeyDown: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onExit: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onExited: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onExiting: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onRendered: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var open: Boolean = js.native
    var role: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var transformOrigin: js.UndefOr[js.Any] = js.native
    var transitionDuration: js.UndefOr[js.Any] = js.native
  }

  @JSImport("@material-ui/core/Menu", JSImport.Default)
  @js.native
  object MenuJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](MenuJS)
  
  /**
   * 
   * @param BackdropComponent
   *        A backdrop component. This property enables custom backdrop rendering.
   *        Passed to Modal
   * @param BackdropProps
   *        Properties applied to the [`Backdrop`](/api/backdrop/) element.
   *        Passed to Modal
   * @param MenuListProps
   *        Properties applied to the [`MenuList`](/api/menu-list/) element.
   * @param ModalClasses
   *        `classes` property applied to the [`Modal`](/api/modal/) element.
   *        Passed to Popover
   * @param PaperProps
   *        Property spread to root element
   * @param PopoverClasses
   *        `classes` property applied to the [`Popover`](/api/popover/) element.
   * @param TransitionComponent
   *        The component used for the transition.
   *        Passed to Popover
   * @param TransitionProps
   *        Properties applied to the `Transition` element.
   *        Passed to Popover
   * @param action
   *        This is callback property. It's called by the component on mount.
   *        This is useful when you want to trigger an action programmatically.
   *        It currently only supports updatePosition() action.
   *        
   *        parameter {object} actions This object contains all posible actions
   *        that can be triggered programmatically.
   *        Passed to Popover
   * @param anchorEl
   *        The DOM element used to set the position of the menu.
   * @param anchorOrigin
   *        This is the point on the anchor where the popover's
   *        `anchorEl` will attach to. This is not used when the
   *        anchorReference is 'anchorPosition'.
   *        
   *        Options:
   *        vertical: [top, center, bottom];
   *        horizontal: [left, center, right].
   *        Passed to Popover
   * @param anchorPosition
   *        This is the position that may be used
   *        to set the position of the popover.
   *        The coordinates are relative to
   *        the application's client area.
   *        Passed to Popover
   * @param anchorReference
   *        
   *        Passed to Popover
   * @param children
   *        Menu contents, normally `MenuItem`s.
   * @param className
   *        Property spread to root element
   *        Passed to Modal
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param container
   *        A node, component instance, or function that returns either.
   *        The `container` will passed to the Modal component.
   *        By default, it uses the body of the anchorEl's top-level document object,
   *        so it's simply `document.body` most of the time.
   *        Passed to Popover
   * @param disableAutoFocus
   *        If `true`, the modal will not automatically shift focus to itself when it opens, and
   *        replace it to the last focused element when it closes.
   *        This also works correctly with any modal children that have the `disableAutoFocus` prop.
   *        
   *        Generally this should never be set to `true` as it makes the modal less
   *        accessible to assistive technologies, like screen readers.
   *        Passed to Modal
   * @param disableAutoFocusItem
   *        If `true`, the selected / first menu item will not be auto focused.
   * @param disableBackdropClick
   *        If `true`, clicking the backdrop will not fire any callback.
   *        Passed to Modal
   * @param disableEnforceFocus
   *        If `true`, the modal will not prevent focus from leaving the modal while open.
   *        
   *        Generally this should never be set to `true` as it makes the modal less
   *        accessible to assistive technologies, like screen readers.
   *        Passed to Modal
   * @param disableEscapeKeyDown
   *        If `true`, hitting escape will not fire any callback.
   *        Passed to Modal
   * @param disablePortal
   *        Disable the portal behavior.
   *        The children stay within it's parent DOM hierarchy.
   *        Passed to Modal
   * @param disableRestoreFocus
   *        If `true`, the modal will not restore focus to previously focused element once
   *        modal is hidden.
   *        Passed to Modal
   * @param elevation
   *        The elevation of the popover.
   *        Passed to Popover
   * @param getContentAnchorEl
   *        This function is called in order to retrieve the content anchor element.
   *        It's the opposite of the `anchorEl` property.
   *        The content anchor element should be an element inside the popover.
   *        It's used to correctly scroll and set the position of the popover.
   *        The positioning strategy tries to make the content anchor element just above the
   *        anchor element.
   *        Passed to Popover
   * @param hideBackdrop
   *        If `true`, the backdrop is not rendered.
   *        Passed to Modal
   * @param keepMounted
   *        Always keep the children in the DOM.
   *        This property can be useful in SEO situation or
   *        when you want to maximize the responsiveness of the Modal.
   *        Passed to Modal
   * @param key
   *        React key
   * @param manager
   *        A modal manager used to track and manage the state of open
   *        Modals. This enables customizing how modals interact within a container.
   *        Passed to Modal
   * @param marginThreshold
   *        Specifies how close to the edge of the window the popover can appear.
   *        Passed to Popover
   * @param onBackdropClick
   *        Callback fired when the backdrop is clicked.
   *        Passed to Modal
   * @param onClose
   *        Callback fired when the component requests to be closed.
   *        
   *        parameter {object} event The event source of the callback
   *        parameter {string} reason Can be:`"escapeKeyDown"`, `"backdropClick"`, `"tabKeyDown"`
   * @param onEnter
   *        Callback fired before the Menu enters.
   * @param onEntered
   *        Callback fired when the Menu has entered.
   * @param onEntering
   *        Callback fired when the Menu is entering.
   * @param onEscapeKeyDown
   *        Callback fired when the escape key is pressed,
   *        `disableEscapeKeyDown` is false and the modal is in focus.
   *        Passed to Modal
   * @param onExit
   *        Callback fired before the Menu exits.
   * @param onExited
   *        Callback fired when the Menu has exited.
   * @param onExiting
   *        Callback fired when the Menu is exiting.
   * @param onRendered
   *        Callback fired once the children has been mounted into the `container`.
   *        It signals that the `open={true}` property took effect.
   *        Passed to Modal
   * @param open
   *        If `true`, the menu is visible.
   * @param role
   *        Property spread to root element
   *        Passed to Popover
   * @param style
   *        React element CSS style
   * @param transformOrigin
   *        This is the point on the popover which
   *        will attach to the anchor's origin.
   *        
   *        Options:
   *        vertical: [top, center, bottom, x(px)];
   *        horizontal: [left, center, right, x(px)].
   *        Passed to Popover
   * @param transitionDuration
   *        The length of the transition in `ms`, or 'auto'
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
    BackdropComponent: js.UndefOr[js.Any] = js.undefined,
    BackdropProps: js.UndefOr[js.Object] = js.undefined,
    MenuListProps: js.UndefOr[js.Object] = js.undefined,
    ModalClasses: js.UndefOr[js.Object] = js.undefined,
    PaperProps: js.UndefOr[js.Object] = js.undefined,
    PopoverClasses: js.UndefOr[js.Object] = js.undefined,
    TransitionComponent: js.UndefOr[js.Any] = js.undefined,
    TransitionProps: js.UndefOr[js.Object] = js.undefined,
    action: js.UndefOr[js.Any] = js.undefined,
    anchorEl: js.UndefOr[js.Any] = js.undefined,
    anchorOrigin: js.UndefOr[js.Any] = js.undefined,
    anchorPosition: js.UndefOr[js.Any] = js.undefined,
    anchorReference: js.UndefOr[AnchorReference] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    container: js.UndefOr[js.Any] = js.undefined,
    disableAutoFocus: js.UndefOr[Boolean] = js.undefined,
    disableAutoFocusItem: js.UndefOr[Boolean] = js.undefined,
    disableBackdropClick: js.UndefOr[Boolean] = js.undefined,
    disableEnforceFocus: js.UndefOr[Boolean] = js.undefined,
    disableEscapeKeyDown: js.UndefOr[Boolean] = js.undefined,
    disablePortal: js.UndefOr[Boolean] = js.undefined,
    disableRestoreFocus: js.UndefOr[Boolean] = js.undefined,
    elevation: js.UndefOr[Double] = js.undefined,
    getContentAnchorEl: js.UndefOr[js.Any] = js.undefined,
    hideBackdrop: js.UndefOr[Boolean] = js.undefined,
    keepMounted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    manager: js.UndefOr[js.Object] = js.undefined,
    marginThreshold: js.UndefOr[Double] = js.undefined,
    onBackdropClick: js.UndefOr[Callback] = js.undefined,
    onClose: js.UndefOr[Callback] = js.undefined,
    onEnter: js.UndefOr[Callback] = js.undefined,
    onEntered: js.UndefOr[Callback] = js.undefined,
    onEntering: js.UndefOr[Callback] = js.undefined,
    onEscapeKeyDown: js.UndefOr[Callback] = js.undefined,
    onExit: js.UndefOr[Callback] = js.undefined,
    onExited: js.UndefOr[Callback] = js.undefined,
    onExiting: js.UndefOr[Callback] = js.undefined,
    onRendered: js.UndefOr[Callback] = js.undefined,
    open: Boolean,
    role: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    transformOrigin: js.UndefOr[js.Any] = js.undefined,
    transitionDuration: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (BackdropComponent.isDefined) {p.BackdropComponent = BackdropComponent}
    if (BackdropProps.isDefined) {p.BackdropProps = BackdropProps}
    if (MenuListProps.isDefined) {p.MenuListProps = MenuListProps}
    if (ModalClasses.isDefined) {p.ModalClasses = ModalClasses}
    if (PaperProps.isDefined) {p.PaperProps = PaperProps}
    if (PopoverClasses.isDefined) {p.PopoverClasses = PopoverClasses}
    if (TransitionComponent.isDefined) {p.TransitionComponent = TransitionComponent}
    if (TransitionProps.isDefined) {p.TransitionProps = TransitionProps}
    if (action.isDefined) {p.action = action}
    if (anchorEl.isDefined) {p.anchorEl = anchorEl}
    if (anchorOrigin.isDefined) {p.anchorOrigin = anchorOrigin}
    if (anchorPosition.isDefined) {p.anchorPosition = anchorPosition}
    if (anchorReference.isDefined) {p.anchorReference = anchorReference.map(v => v.value)}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (container.isDefined) {p.container = container}
    if (disableAutoFocus.isDefined) {p.disableAutoFocus = disableAutoFocus}
    if (disableAutoFocusItem.isDefined) {p.disableAutoFocusItem = disableAutoFocusItem}
    if (disableBackdropClick.isDefined) {p.disableBackdropClick = disableBackdropClick}
    if (disableEnforceFocus.isDefined) {p.disableEnforceFocus = disableEnforceFocus}
    if (disableEscapeKeyDown.isDefined) {p.disableEscapeKeyDown = disableEscapeKeyDown}
    if (disablePortal.isDefined) {p.disablePortal = disablePortal}
    if (disableRestoreFocus.isDefined) {p.disableRestoreFocus = disableRestoreFocus}
    if (elevation.isDefined) {p.elevation = elevation}
    if (getContentAnchorEl.isDefined) {p.getContentAnchorEl = getContentAnchorEl}
    if (hideBackdrop.isDefined) {p.hideBackdrop = hideBackdrop}
    if (keepMounted.isDefined) {p.keepMounted = keepMounted}
    if (key.isDefined) {p.key = key}
    if (manager.isDefined) {p.manager = manager}
    if (marginThreshold.isDefined) {p.marginThreshold = marginThreshold}
    if (onBackdropClick.isDefined) {p.onBackdropClick = onBackdropClick.map(v => v.toJsFn)}
    if (onClose.isDefined) {p.onClose = onClose.map(v => v.toJsFn)}
    if (onEnter.isDefined) {p.onEnter = onEnter.map(v => v.toJsFn)}
    if (onEntered.isDefined) {p.onEntered = onEntered.map(v => v.toJsFn)}
    if (onEntering.isDefined) {p.onEntering = onEntering.map(v => v.toJsFn)}
    if (onEscapeKeyDown.isDefined) {p.onEscapeKeyDown = onEscapeKeyDown.map(v => v.toJsFn)}
    if (onExit.isDefined) {p.onExit = onExit.map(v => v.toJsFn)}
    if (onExited.isDefined) {p.onExited = onExited.map(v => v.toJsFn)}
    if (onExiting.isDefined) {p.onExiting = onExiting.map(v => v.toJsFn)}
    if (onRendered.isDefined) {p.onRendered = onRendered.map(v => v.toJsFn)}
    p.open = open
    if (role.isDefined) {p.role = role}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (transformOrigin.isDefined) {p.transformOrigin = transformOrigin}
    if (transitionDuration.isDefined) {p.transitionDuration = transitionDuration}

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
        