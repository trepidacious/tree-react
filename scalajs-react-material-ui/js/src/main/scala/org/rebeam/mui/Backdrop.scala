
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

// import japgolly.scalajs.react.vdom.html_<^._

object Backdrop {
  
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var invisible: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var open: Boolean = js.native
    var style: js.UndefOr[js.Object] = js.native
    var transitionDuration: js.UndefOr[js.Any] = js.native
  }

  @JSImport("@material-ui/core/Backdrop", JSImport.Default)
  @js.native
  object BackdropJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.None](BackdropJS)
  
  /**
   * 
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param invisible
   *        If `true`, the backdrop is invisible.
   *        It can be used when rendering a popover or a custom select component.
   * @param key
   *        React key
   * @param open
   *        If `true`, the backdrop is open.
   * @param style
   *        React element CSS style
   * @param transitionDuration
   *        The duration for the transition, in milliseconds.
   *        You may specify a single timeout for all transitions, or individually with an object.
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
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    invisible: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    open: Boolean,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    transitionDuration: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (invisible.isDefined) {p.invisible = invisible}
    if (key.isDefined) {p.key = key}
    p.open = open
    if (style.isDefined) {p.style = style.map(v => v.o)}
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
    
    jsComponent(p)
  }

}
        