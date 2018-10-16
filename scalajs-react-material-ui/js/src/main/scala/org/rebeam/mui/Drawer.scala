
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Drawer {
  
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
    var elevation: js.UndefOr[Double] = js.native
    var key: js.UndefOr[String] = js.native
    var onClose: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var open: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var theme: js.Object = js.native
    var transitionDuration: js.UndefOr[js.Any] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/Drawer", JSImport.Default)
  @js.native
  object DrawerJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](DrawerJS)
  
  /**
   * The properties of the [Modal](/api/modal/) component are available
   * when `variant="temporary"` is set.
   * @param ModalProps
   *        Properties applied to the [`Modal`](/api/modal/) element.
   * @param PaperProps
   *        Properties applied to the [`Paper`](/api/paper/) element.
   * @param SlideProps
   *        Properties applied to the [`Slide`](/api/slide/) element.
   * @param anchor
   *        Side from which the drawer will appear.
   * @param children
   *        The contents of the drawer.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param elevation
   *        The elevation of the drawer.
   * @param key
   *        React key
   * @param onClose
   *        Callback fired when the component requests to be closed.
   *        
   *        parameter {object} event The event source of the callback
   * @param open
   *        If `true`, the drawer is open.
   * @param style
   *        React element CSS style
   * @param theme
   *        Property spread to root element
   * @param transitionDuration
   *        The duration for the transition, in milliseconds.
   *        You may specify a single timeout for all transitions, or individually with an object.
   * @param variant
   *        The variant to use.
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
    elevation: js.UndefOr[Double] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onClose: js.UndefOr[Callback] = js.undefined,
    open: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
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
    if (elevation.isDefined) {p.elevation = elevation}
    if (key.isDefined) {p.key = key}
    if (onClose.isDefined) {p.onClose = onClose.map(v => v.toJsFn)}
    if (open.isDefined) {p.open = open}
    if (style.isDefined) {p.style = style.map(v => v.o)}
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
        