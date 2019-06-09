
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object DimmerInner {
  
  sealed trait VerticalAlign{ val value: String }

  object VerticalAlign {
    case object Bottom extends VerticalAlign { val value: String = "bottom" }
    case object Top extends VerticalAlign { val value: String = "top" }
  }
          
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var inverted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var onClickOutside: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var page: js.UndefOr[Boolean] = js.native
    var simple: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var verticalAlign: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "DimmerInner")
  @js.native
  object DimmerInnerJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](DimmerInnerJS)
  
  /**
   * An inner element for a Dimmer.
   * @param active
   *        An active dimmer will dim its parent container.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param disabled
   *        A disabled dimmer cannot be activated
   * @param inverted
   *        A dimmer can be formatted to have its colors inverted.
   * @param key
   *        React key
   * @param onClick
   *        Called on click.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param onClickOutside
   *        Handles click outside Dimmer's content, but inside Dimmer area.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param page
   *        A dimmer can be formatted to be fixed to the page.
   * @param simple
   *        A dimmer can be controlled with simple prop.
   * @param style
   *        React element CSS style
   * @param verticalAlign
   *        A dimmer can have its content top or bottom aligned.
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
    as: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    onClickOutside: js.UndefOr[Callback] = js.undefined,
    page: js.UndefOr[Boolean] = js.undefined,
    simple: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    verticalAlign: js.UndefOr[VerticalAlign] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (disabled.isDefined) {p.disabled = disabled}
    if (inverted.isDefined) {p.inverted = inverted}
    if (key.isDefined) {p.key = key}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (onClickOutside.isDefined) {p.onClickOutside = onClickOutside.map(v => v.toJsFn)}
    if (page.isDefined) {p.page = page}
    if (simple.isDefined) {p.simple = simple}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (verticalAlign.isDefined) {p.verticalAlign = verticalAlign.map(v => v.value)}

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
        