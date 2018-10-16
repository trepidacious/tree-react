
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object SwipeableDrawer {
  
  sealed trait Anchor{ val value: String }

  object Anchor {
    case object Left extends Anchor { val value: String = "left" }
    case object Top extends Anchor { val value: String = "top" }
    case object Right extends Anchor { val value: String = "right" }
    case object Bottom extends Anchor { val value: String = "bottom" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Permanent extends Variant { val value: String = "permanent" }
    case object Persistent extends Variant { val value: String = "persistent" }
    case object Temporary extends Variant { val value: String = "temporary" }
  }
          
  @js.native
  trait Props extends js.Object {
    var ModalProps: js.UndefOr[js.Object] = js.native
    var PaperProps: js.UndefOr[js.Object] = js.native
    var SlideProps: js.UndefOr[js.Object] = js.native
    var anchor: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var disableBackdropTransition: js.UndefOr[Boolean] = js.native
    var disableDiscovery: js.UndefOr[Boolean] = js.native
    var disableSwipeToOpen: js.UndefOr[Boolean] = js.native
    var elevation: js.UndefOr[Double] = js.native
    var hysteresis: js.UndefOr[Double] = js.native
    var key: js.UndefOr[String] = js.native
    var minFlingVelocity: js.UndefOr[Double] = js.native
    var onClose: scalajs.js.Function0[Unit] = js.native
    var onOpen: scalajs.js.Function0[Unit] = js.native
    var open: Boolean = js.native
    var style: js.UndefOr[js.Object] = js.native
    var swipeAreaWidth: js.UndefOr[Double] = js.native
    var theme: js.Object = js.native
    var transitionDuration: js.UndefOr[js.Any] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/SwipeableDrawer", JSImport.Default)
  @js.native
  object SwipeableDrawerJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](SwipeableDrawerJS)
  
  /**
   * 
   * @param ModalProps
   *        Property spread to root element
   * @param PaperProps
   *        Property spread to root element
   * @param SlideProps
   *        Properties applied to the [`Slide`](/api/slide/) element.
   *        Passed to Drawer
   * @param anchor
   *        Property spread to root element
   * @param children
   *        The contents of the drawer.
   *        Passed to Drawer
   * @param className
   *        Property spread to root element
   *        Passed to Drawer
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   *        Passed to Drawer
   * @param disableBackdropTransition
   *        Disable the backdrop transition.
   *        This can improve the FPS on low-end devices.
   * @param disableDiscovery
   *        If `true`, touching the screen near the edge of the drawer will not slide in the drawer a bit
   *        to promote accidental discovery of the swipe gesture.
   * @param disableSwipeToOpen
   *        If `true`, swipe to open is disabled. This is useful in browsers where swiping triggers
   *        navigation actions. Swipe to open is disabled on iOS browsers by default.
   * @param elevation
   *        The elevation of the drawer.
   *        Passed to Drawer
   * @param hysteresis
   *        Affects how far the drawer must be opened/closed to change his state.
   *        Specified as percent (0-1) of the width of the drawer
   * @param key
   *        React key
   * @param minFlingVelocity
   *        Defines, from which (average) velocity on, the swipe is
   *        defined as complete although hysteresis isn't reached.
   *        Good threshold is between 250 - 1000 px/s
   * @param onClose
   *        Callback fired when the component requests to be closed.
   *        
   *        parameter {object} event The event source of the callback
   * @param onOpen
   *        Callback fired when the component requests to be opened.
   *        
   *        parameter {object} event The event source of the callback
   * @param open
   *        If `true`, the drawer is open.
   * @param style
   *        React element CSS style
   * @param swipeAreaWidth
   *        The width of the left most (or right most) area in pixels where the
   *        drawer can be swiped open from.
   * @param theme
   *        Property spread to root element
   * @param transitionDuration
   *        The duration for the transition, in milliseconds.
   *        You may specify a single timeout for all transitions, or individually with an object.
   * @param variant
   *        Property spread to root element
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
    ModalProps: js.UndefOr[js.Object] = js.undefined,
    PaperProps: js.UndefOr[js.Object] = js.undefined,
    SlideProps: js.UndefOr[js.Object] = js.undefined,
    anchor: js.UndefOr[Anchor] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    disableBackdropTransition: js.UndefOr[Boolean] = js.undefined,
    disableDiscovery: js.UndefOr[Boolean] = js.undefined,
    disableSwipeToOpen: js.UndefOr[Boolean] = js.undefined,
    elevation: js.UndefOr[Double] = js.undefined,
    hysteresis: js.UndefOr[Double] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    minFlingVelocity: js.UndefOr[Double] = js.undefined,
    onClose: Callback,
    onOpen: Callback,
    open: Boolean,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    swipeAreaWidth: js.UndefOr[Double] = js.undefined,
    theme: js.Object,
    transitionDuration: js.UndefOr[js.Any] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (ModalProps.isDefined) {p.ModalProps = ModalProps}
    if (PaperProps.isDefined) {p.PaperProps = PaperProps}
    if (SlideProps.isDefined) {p.SlideProps = SlideProps}
    if (anchor.isDefined) {p.anchor = anchor.map(v => v.value)}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (disableBackdropTransition.isDefined) {p.disableBackdropTransition = disableBackdropTransition}
    if (disableDiscovery.isDefined) {p.disableDiscovery = disableDiscovery}
    if (disableSwipeToOpen.isDefined) {p.disableSwipeToOpen = disableSwipeToOpen}
    if (elevation.isDefined) {p.elevation = elevation}
    if (hysteresis.isDefined) {p.hysteresis = hysteresis}
    if (key.isDefined) {p.key = key}
    if (minFlingVelocity.isDefined) {p.minFlingVelocity = minFlingVelocity}
    p.onClose = onClose.toJsFn
    p.onOpen = onOpen.toJsFn
    p.open = open
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (swipeAreaWidth.isDefined) {p.swipeAreaWidth = swipeAreaWidth}
    p.theme = theme
    if (transitionDuration.isDefined) {p.transitionDuration = transitionDuration}
    if (variant.isDefined) {p.variant = variant.map(v => v.value)}

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
        