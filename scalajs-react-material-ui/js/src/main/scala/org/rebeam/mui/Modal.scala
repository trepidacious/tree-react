
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Modal {
  
  @js.native
  trait Props extends js.Object {
    var BackdropComponent: js.UndefOr[js.Any] = js.native
    var BackdropProps: js.UndefOr[js.Object] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var container: js.UndefOr[js.Any] = js.native
    var disableAutoFocus: js.UndefOr[Boolean] = js.native
    var disableBackdropClick: js.UndefOr[Boolean] = js.native
    var disableEnforceFocus: js.UndefOr[Boolean] = js.native
    var disableEscapeKeyDown: js.UndefOr[Boolean] = js.native
    var disablePortal: js.UndefOr[Boolean] = js.native
    var disableRestoreFocus: js.UndefOr[Boolean] = js.native
    var hideBackdrop: js.UndefOr[Boolean] = js.native
    var keepMounted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var manager: js.UndefOr[js.Object] = js.native
    var onBackdropClick: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onClose: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onEscapeKeyDown: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onRendered: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var open: Boolean = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/Modal", JSImport.Default)
  @js.native
  object ModalJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](ModalJS)
  
  /**
   * This component shares many concepts with [react-overlays](https://react-bootstrap.github.io/react-overlays/#modals).
   * @param BackdropComponent
   *        A backdrop component. This property enables custom backdrop rendering.
   * @param BackdropProps
   *        Properties applied to the [`Backdrop`](/api/backdrop/) element.
   * @param children
   *        A single child content element.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param container
   *        A node, component instance, or function that returns either.
   *        The `container` will have the portal children appended to it.
   * @param disableAutoFocus
   *        If `true`, the modal will not automatically shift focus to itself when it opens, and
   *        replace it to the last focused element when it closes.
   *        This also works correctly with any modal children that have the `disableAutoFocus` prop.
   *        
   *        Generally this should never be set to `true` as it makes the modal less
   *        accessible to assistive technologies, like screen readers.
   * @param disableBackdropClick
   *        If `true`, clicking the backdrop will not fire any callback.
   * @param disableEnforceFocus
   *        If `true`, the modal will not prevent focus from leaving the modal while open.
   *        
   *        Generally this should never be set to `true` as it makes the modal less
   *        accessible to assistive technologies, like screen readers.
   * @param disableEscapeKeyDown
   *        If `true`, hitting escape will not fire any callback.
   * @param disablePortal
   *        Disable the portal behavior.
   *        The children stay within it's parent DOM hierarchy.
   * @param disableRestoreFocus
   *        If `true`, the modal will not restore focus to previously focused element once
   *        modal is hidden.
   * @param hideBackdrop
   *        If `true`, the backdrop is not rendered.
   * @param keepMounted
   *        Always keep the children in the DOM.
   *        This property can be useful in SEO situation or
   *        when you want to maximize the responsiveness of the Modal.
   * @param key
   *        React key
   * @param manager
   *        A modal manager used to track and manage the state of open
   *        Modals. This enables customizing how modals interact within a container.
   * @param onBackdropClick
   *        Callback fired when the backdrop is clicked.
   * @param onClose
   *        Callback fired when the component requests to be closed.
   *        The `reason` parameter can optionally be used to control the response to `onClose`.
   *        
   *        parameter {object} event The event source of the callback
   *        parameter {string} reason Can be:`"escapeKeyDown"`, `"backdropClick"`
   * @param onEscapeKeyDown
   *        Callback fired when the escape key is pressed,
   *        `disableEscapeKeyDown` is false and the modal is in focus.
   * @param onRendered
   *        Callback fired once the children has been mounted into the `container`.
   *        It signals that the `open={true}` property took effect.
   * @param open
   *        If `true`, the modal is open.
   * @param style
   *        React element CSS style
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
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    container: js.UndefOr[js.Any] = js.undefined,
    disableAutoFocus: js.UndefOr[Boolean] = js.undefined,
    disableBackdropClick: js.UndefOr[Boolean] = js.undefined,
    disableEnforceFocus: js.UndefOr[Boolean] = js.undefined,
    disableEscapeKeyDown: js.UndefOr[Boolean] = js.undefined,
    disablePortal: js.UndefOr[Boolean] = js.undefined,
    disableRestoreFocus: js.UndefOr[Boolean] = js.undefined,
    hideBackdrop: js.UndefOr[Boolean] = js.undefined,
    keepMounted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    manager: js.UndefOr[js.Object] = js.undefined,
    onBackdropClick: js.UndefOr[Callback] = js.undefined,
    onClose: js.UndefOr[Callback] = js.undefined,
    onEscapeKeyDown: js.UndefOr[Callback] = js.undefined,
    onRendered: js.UndefOr[Callback] = js.undefined,
    open: Boolean,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (BackdropComponent.isDefined) {p.BackdropComponent = BackdropComponent}
    if (BackdropProps.isDefined) {p.BackdropProps = BackdropProps}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (container.isDefined) {p.container = container}
    if (disableAutoFocus.isDefined) {p.disableAutoFocus = disableAutoFocus}
    if (disableBackdropClick.isDefined) {p.disableBackdropClick = disableBackdropClick}
    if (disableEnforceFocus.isDefined) {p.disableEnforceFocus = disableEnforceFocus}
    if (disableEscapeKeyDown.isDefined) {p.disableEscapeKeyDown = disableEscapeKeyDown}
    if (disablePortal.isDefined) {p.disablePortal = disablePortal}
    if (disableRestoreFocus.isDefined) {p.disableRestoreFocus = disableRestoreFocus}
    if (hideBackdrop.isDefined) {p.hideBackdrop = hideBackdrop}
    if (keepMounted.isDefined) {p.keepMounted = keepMounted}
    if (key.isDefined) {p.key = key}
    if (manager.isDefined) {p.manager = manager}
    if (onBackdropClick.isDefined) {p.onBackdropClick = onBackdropClick.map(v => v.toJsFn)}
    if (onClose.isDefined) {p.onClose = onClose.map(v => v.toJsFn)}
    if (onEscapeKeyDown.isDefined) {p.onEscapeKeyDown = onEscapeKeyDown.map(v => v.toJsFn)}
    if (onRendered.isDefined) {p.onRendered = onRendered.map(v => v.toJsFn)}
    p.open = open
    if (style.isDefined) {p.style = style.map(v => v.o)}

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
        