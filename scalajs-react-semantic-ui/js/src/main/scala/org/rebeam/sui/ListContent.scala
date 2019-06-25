
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object ListContent {
  
  sealed trait Floated{ val value: String }

  object Floated {
    case object Left extends Floated { val value: String = "left" }
    case object Right extends Floated { val value: String = "right" }
  }
            
  sealed trait VerticalAlign{ val value: String }

  object VerticalAlign {
    case object Bottom extends VerticalAlign { val value: String = "bottom" }
    case object Middle extends VerticalAlign { val value: String = "middle" }
    case object Top extends VerticalAlign { val value: String = "top" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var description: js.UndefOr[js.Any] = js.native
    var floated: js.UndefOr[String] = js.native
    var header: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var verticalAlign: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "ListContent")
  @js.native
  object ListContentJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](ListContentJS)
  
  /**
   * A list item can contain a content.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param description
   *        Shorthand for ListDescription.
   * @param floated
   *        An list content can be floated left or right.
   * @param header
   *        Shorthand for ListHeader.
   * @param key
   *        React key
   * @param style
   *        React element CSS style
   * @param verticalAlign
   *        An element inside a list can be vertically aligned.
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
    description: js.UndefOr[js.Any] = js.undefined,
    floated: js.UndefOr[Floated] = js.undefined,
    header: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    verticalAlign: js.UndefOr[VerticalAlign] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (description.isDefined) {p.description = description}
    if (floated.isDefined) {p.floated = floated.map(v => v.value)}
    if (header.isDefined) {p.header = header}
    if (key.isDefined) {p.key = key}
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
        