
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Sticky {
  
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[String] = js.native
    var bottomOffset: js.UndefOr[Double] = js.native
    var className: js.UndefOr[String] = js.native
    var context: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var offset: js.UndefOr[Double] = js.native
    var onBottom: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onStick: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onTop: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onUnstick: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var pushing: js.UndefOr[Boolean] = js.native
    var scrollContext: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var styleElement: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "Sticky")
  @js.native
  object StickyJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](StickyJS)
  
  /**
   * Sticky content stays fixed to the browser viewport while another column of content is visible on the page.
   * @param active
   *        A Sticky can be active.
   * @param as
   *        An element type to render as (string or function).
   * @param bottomOffset
   *        Offset in pixels from the bottom of the screen when fixing element to viewport.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param context
   *        Context which sticky element should stick to.
   * @param key
   *        React key
   * @param offset
   *        Offset in pixels from the top of the screen when fixing element to viewport.
   * @param onBottom
   *        Callback when element is bound to bottom of parent container.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param onStick
   *        Callback when element is fixed to page.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param onTop
   *        Callback when element is bound to top of parent container.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param onUnstick
   *        Callback when element is unfixed from page.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param pushing
   *        Whether element should be "pushed" by the viewport, attaching to the bottom of the screen when scrolling up.
   * @param scrollContext
   *        Context which sticky should attach onscroll events.
   * @param style
   *        React element CSS style
   * @param styleElement
   *        Custom style for sticky element.
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
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.UndefOr[String] = js.undefined,
    bottomOffset: js.UndefOr[Double] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    context: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    offset: js.UndefOr[Double] = js.undefined,
    onBottom: js.UndefOr[Callback] = js.undefined,
    onStick: js.UndefOr[Callback] = js.undefined,
    onTop: js.UndefOr[Callback] = js.undefined,
    onUnstick: js.UndefOr[Callback] = js.undefined,
    pushing: js.UndefOr[Boolean] = js.undefined,
    scrollContext: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    styleElement: js.UndefOr[js.Object] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (as.isDefined) {p.as = as}
    if (bottomOffset.isDefined) {p.bottomOffset = bottomOffset}
    if (className.isDefined) {p.className = className}
    if (context.isDefined) {p.context = context}
    if (key.isDefined) {p.key = key}
    if (offset.isDefined) {p.offset = offset}
    if (onBottom.isDefined) {p.onBottom = onBottom.map(v => v.toJsFn)}
    if (onStick.isDefined) {p.onStick = onStick.map(v => v.toJsFn)}
    if (onTop.isDefined) {p.onTop = onTop.map(v => v.toJsFn)}
    if (onUnstick.isDefined) {p.onUnstick = onUnstick.map(v => v.toJsFn)}
    if (pushing.isDefined) {p.pushing = pushing}
    if (scrollContext.isDefined) {p.scrollContext = scrollContext}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (styleElement.isDefined) {p.styleElement = styleElement}

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
        