
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Popper {
  
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
    var anchorEl: js.UndefOr[js.Any] = js.native
    var container: js.UndefOr[js.Any] = js.native
    var disablePortal: js.UndefOr[Boolean] = js.native
    var keepMounted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var modifiers: js.UndefOr[js.Object] = js.native
    var open: Boolean = js.native
    var placement: js.UndefOr[String] = js.native
    var popperOptions: js.UndefOr[js.Object] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var transition: js.UndefOr[Boolean] = js.native
  }

  @JSImport("@material-ui/core/Popper", JSImport.Default)
  @js.native
  object PopperJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](PopperJS)
  
  /**
   * Poppers rely on the 3rd party library [Popper.js](https://github.com/FezVrasta/popper.js) for positioning.
   * @param anchorEl
   *        This is the DOM element, or a function that returns the DOM element,
   *        that may be used to set the position of the popover.
   *        The return value will passed as the reference object of the Popper
   *        instance.
   * @param children
   *        Popper render function or node.
   * @param container
   *        A node, component instance, or function that returns either.
   *        The `container` will passed to the Modal component.
   *        By default, it uses the body of the anchorEl's top-level document object,
   *        so it's simply `document.body` most of the time.
   * @param disablePortal
   *        Disable the portal behavior.
   *        The children stay within it's parent DOM hierarchy.
   * @param keepMounted
   *        Always keep the children in the DOM.
   *        This property can be useful in SEO situation or
   *        when you want to maximize the responsiveness of the Popper.
   * @param key
   *        React key
   * @param modifiers
   *        Popper.js is based on a "plugin-like" architecture,
   *        most of its features are fully encapsulated "modifiers".
   *        
   *        A modifier is a function that is called each time Popper.js needs to
   *        compute the position of the popper.
   *        For this reason, modifiers should be very performant to avoid bottlenecks.
   *        To learn how to create a modifier, [read the modifiers documentation](https://github.com/FezVrasta/popper.js/blob/master/docs/_includes/popper-documentation.md#modifiers--object).
   * @param open
   *        If `true`, the popper is visible.
   * @param placement
   *        Popper placement.
   * @param popperOptions
   *        Options provided to the [`popper.js`](https://github.com/FezVrasta/popper.js) instance.
   * @param style
   *        React element CSS style
   * @param transition
   *        Help supporting a react-transition-group/Transition component.
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
    anchorEl: js.UndefOr[js.Any] = js.undefined,
    container: js.UndefOr[js.Any] = js.undefined,
    disablePortal: js.UndefOr[Boolean] = js.undefined,
    keepMounted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    modifiers: js.UndefOr[js.Object] = js.undefined,
    open: Boolean,
    placement: js.UndefOr[Placement] = js.undefined,
    popperOptions: js.UndefOr[js.Object] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    transition: js.UndefOr[Boolean] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (anchorEl.isDefined) {p.anchorEl = anchorEl}
    if (container.isDefined) {p.container = container}
    if (disablePortal.isDefined) {p.disablePortal = disablePortal}
    if (keepMounted.isDefined) {p.keepMounted = keepMounted}
    if (key.isDefined) {p.key = key}
    if (modifiers.isDefined) {p.modifiers = modifiers}
    p.open = open
    if (placement.isDefined) {p.placement = placement.map(v => v.value)}
    if (popperOptions.isDefined) {p.popperOptions = popperOptions}
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
        