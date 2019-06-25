
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object DropdownMenu {
  
  sealed trait Direction{ val value: String }

  object Direction {
    case object Left extends Direction { val value: String = "left" }
    case object Right extends Direction { val value: String = "right" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var direction: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var open: js.UndefOr[Boolean] = js.native
    var scrolling: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "DropdownMenu")
  @js.native
  object DropdownMenuJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](DropdownMenuJS)
  
  /**
   * A dropdown menu can contain a menu.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param direction
   *        A dropdown menu can open to the left or to the right.
   * @param key
   *        React key
   * @param open
   *        Whether or not the dropdown menu is displayed.
   * @param scrolling
   *        A dropdown menu can scroll.
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
    as: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    direction: js.UndefOr[Direction] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    open: js.UndefOr[Boolean] = js.undefined,
    scrolling: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (direction.isDefined) {p.direction = direction.map(v => v.value)}
    if (key.isDefined) {p.key = key}
    if (open.isDefined) {p.open = open}
    if (scrolling.isDefined) {p.scrolling = scrolling}
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
        