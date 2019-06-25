
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Rail {
  
  sealed trait Position{ val value: String }

  object Position {
    case object Left extends Position { val value: String = "left" }
    case object Right extends Position { val value: String = "right" }
  }
            
  sealed trait Size{ val value: String }

  object Size {
    case object Mini extends Size { val value: String = "mini" }
    case object Tiny extends Size { val value: String = "tiny" }
    case object Massive extends Size { val value: String = "massive" }
    case object Small extends Size { val value: String = "small" }
    case object Big extends Size { val value: String = "big" }
    case object Huge extends Size { val value: String = "huge" }
    case object Large extends Size { val value: String = "large" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var attached: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var close: js.UndefOr[js.Any] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var dividing: js.UndefOr[Boolean] = js.native
    var internal: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var position: String = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "Rail")
  @js.native
  object RailJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](RailJS)
  
  /**
   * A rail is used to show accompanying content outside the boundaries of the main view of a site.
   * @param as
   *        An element type to render as (string or function).
   * @param attached
   *        A rail can appear attached to the main viewport.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param close
   *        A rail can appear closer to the main viewport.
   * @param content
   *        Shorthand for primary content.
   * @param dividing
   *        A rail can create a division between itself and a container.
   * @param internal
   *        A rail can attach itself to the inside of a container.
   * @param key
   *        React key
   * @param position
   *        A rail can be presented on the left or right side of a container.
   * @param size
   *        A rail can have different sizes.
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
    attached: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    close: js.UndefOr[js.Any] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    dividing: js.UndefOr[Boolean] = js.undefined,
    internal: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    position: Position,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (attached.isDefined) {p.attached = attached}
    if (className.isDefined) {p.className = className}
    if (close.isDefined) {p.close = close}
    if (content.isDefined) {p.content = content}
    if (dividing.isDefined) {p.dividing = dividing}
    if (internal.isDefined) {p.internal = internal}
    if (key.isDefined) {p.key = key}
    p.position = position.value
    if (size.isDefined) {p.size = size.map(v => v.value)}
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
        