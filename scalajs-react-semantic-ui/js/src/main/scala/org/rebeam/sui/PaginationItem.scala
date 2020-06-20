
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

// import japgolly.scalajs.react.vdom.html_<^._

object PaginationItem {
  
  sealed trait `type`{ val value: String }

  object `type` {
    case object EllipsisItem extends `type` { val value: String = "ellipsisItem" }
    case object PageItem extends `type` { val value: String = "pageItem" }
    case object LastItem extends `type` { val value: String = "lastItem" }
    case object NextItem extends `type` { val value: String = "nextItem" }
    case object FirstItem extends `type` { val value: String = "firstItem" }
    case object PrevItem extends `type` { val value: String = "prevItem" }
  }
          
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var onKeyDown: js.UndefOr[scalajs.js.Function1[ReactKeyboardEvent, Unit]] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var `type`: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "PaginationItem")
  @js.native
  object PaginationItemJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](PaginationItemJS)
  
  /**
   * An item of a pagination.
   * @param active
   *        A pagination item can be active.
   * @param disabled
   *        A pagination item can be disabled.
   * @param key
   *        React key
   * @param onClick
   *        Called on click.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param onKeyDown
   *        Called on key down.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param style
   *        React element CSS style
   * @param `type`
   *        A pagination should have a type.
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
    disabled: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    onKeyDown: js.UndefOr[ReactKeyboardEvent => Callback] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    `type`: js.UndefOr[`type`] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (disabled.isDefined) {p.disabled = disabled}
    if (key.isDefined) {p.key = key}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (onKeyDown.isDefined) {p.onKeyDown = onKeyDown.map(v => (e: ReactKeyboardEvent) => v(e).runNow())}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (`type`.isDefined) {p.`type` = `type`.map(v => v.value)}

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
        