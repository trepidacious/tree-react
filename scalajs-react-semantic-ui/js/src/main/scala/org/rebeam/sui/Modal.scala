
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Modal {
  
  sealed trait Dimmer{ val value: String }

  object Dimmer {
    case object True extends Dimmer { val value: String = "true" }
    case object Inverted extends Dimmer { val value: String = "inverted" }
    case object Blurring extends Dimmer { val value: String = "blurring" }
  }
            
  sealed trait Size{ val value: String }

  object Size {
    case object Mini extends Size { val value: String = "mini" }
    case object Tiny extends Size { val value: String = "tiny" }
    case object Small extends Size { val value: String = "small" }
    case object Fullscreen extends Size { val value: String = "fullscreen" }
    case object Large extends Size { val value: String = "large" }
  }
          
  @js.native
  trait Props extends js.Object {
    var actions: js.UndefOr[js.Any] = js.native
    var as: js.UndefOr[String] = js.native
    var basic: js.UndefOr[Boolean] = js.native
    var centered: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var closeIcon: js.UndefOr[js.Any] = js.native
    var closeOnDimmerClick: js.UndefOr[Boolean] = js.native
    var closeOnDocumentClick: js.UndefOr[Boolean] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var defaultOpen: js.UndefOr[Boolean] = js.native
    var dimmer: js.UndefOr[String] = js.native
    var eventPool: js.UndefOr[String] = js.native
    var header: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var mountNode: js.UndefOr[js.Any] = js.native
    var onActionClick: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onClose: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onMount: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onOpen: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onUnmount: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var open: js.UndefOr[Boolean] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var trigger: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
  }

  @JSImport("semantic-ui-react", "Modal")
  @js.native
  object ModalJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](ModalJS)
  
  /**
   * A modal displays content that temporarily blocks interactions with the main view of a site.
   * @see Confirm
   * @see Portal
   * @param actions
   *        Shorthand for Modal.Actions. Typically an array of button shorthand.
   * @param as
   *        An element type to render as (string or function).
   * @param basic
   *        A modal can reduce its complexity
   * @param centered
   *        A modal can be vertically centered in the viewport
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param closeIcon
   *        Shorthand for the close icon. Closes the modal on click.
   * @param closeOnDimmerClick
   *        Whether or not the Modal should close when the dimmer is clicked.
   * @param closeOnDocumentClick
   *        Whether or not the Modal should close when the document is clicked.
   * @param content
   *        Simple text content for the Modal.
   * @param defaultOpen
   *        Initial value of open.
   * @param dimmer
   *        A Modal can appear in a dimmer.
   * @param eventPool
   *        Event pool namespace that is used to handle component events
   * @param header
   *        Modal displayed above the content in bold.
   * @param key
   *        React key
   * @param mountNode
   *        The node where the modal should mount. Defaults to document.body.
   * @param onActionClick
   *        Action onClick handler when using shorthand `actions`.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
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
   * @param open
   *        Controls whether or not the Modal is displayed.
   * @param size
   *        A modal can vary in size
   * @param style
   *        Custom styles.
   * @param trigger
   *        Element to be rendered in-place where the portal is defined.
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
    actions: js.UndefOr[js.Any] = js.undefined,
    as: js.UndefOr[String] = js.undefined,
    basic: js.UndefOr[Boolean] = js.undefined,
    centered: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    closeIcon: js.UndefOr[js.Any] = js.undefined,
    closeOnDimmerClick: js.UndefOr[Boolean] = js.undefined,
    closeOnDocumentClick: js.UndefOr[Boolean] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    defaultOpen: js.UndefOr[Boolean] = js.undefined,
    dimmer: js.UndefOr[Dimmer] = js.undefined,
    eventPool: js.UndefOr[String] = js.undefined,
    header: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    mountNode: js.UndefOr[js.Any] = js.undefined,
    onActionClick: js.UndefOr[Callback] = js.undefined,
    onClose: js.UndefOr[Callback] = js.undefined,
    onMount: js.UndefOr[Callback] = js.undefined,
    onOpen: js.UndefOr[Callback] = js.undefined,
    onUnmount: js.UndefOr[Callback] = js.undefined,
    open: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    trigger: js.UndefOr[VdomNode] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (actions.isDefined) {p.actions = actions}
    if (as.isDefined) {p.as = as}
    if (basic.isDefined) {p.basic = basic}
    if (centered.isDefined) {p.centered = centered}
    if (className.isDefined) {p.className = className}
    if (closeIcon.isDefined) {p.closeIcon = closeIcon}
    if (closeOnDimmerClick.isDefined) {p.closeOnDimmerClick = closeOnDimmerClick}
    if (closeOnDocumentClick.isDefined) {p.closeOnDocumentClick = closeOnDocumentClick}
    if (content.isDefined) {p.content = content}
    if (defaultOpen.isDefined) {p.defaultOpen = defaultOpen}
    if (dimmer.isDefined) {p.dimmer = dimmer.map(v => v.value)}
    if (eventPool.isDefined) {p.eventPool = eventPool}
    if (header.isDefined) {p.header = header}
    if (key.isDefined) {p.key = key}
    if (mountNode.isDefined) {p.mountNode = mountNode}
    if (onActionClick.isDefined) {p.onActionClick = onActionClick.map(v => v.toJsFn)}
    if (onClose.isDefined) {p.onClose = onClose.map(v => v.toJsFn)}
    if (onMount.isDefined) {p.onMount = onMount.map(v => v.toJsFn)}
    if (onOpen.isDefined) {p.onOpen = onOpen.map(v => v.toJsFn)}
    if (onUnmount.isDefined) {p.onUnmount = onUnmount.map(v => v.toJsFn)}
    if (open.isDefined) {p.open = open}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (trigger.isDefined) {p.trigger = trigger.map(v => v.rawNode)}

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
        