
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Container {
  
  sealed trait TextAlign{ val value: String }

  object TextAlign {
    case object Left extends TextAlign { val value: String = "left" }
    case object Center extends TextAlign { val value: String = "center" }
    case object Right extends TextAlign { val value: String = "right" }
    case object Justified extends TextAlign { val value: String = "justified" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var fluid: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var text: js.UndefOr[Boolean] = js.native
    var textAlign: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "Container")
  @js.native
  object ContainerJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](ContainerJS)
  
  /**
   * A container limits content to a maximum width.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param fluid
   *        Container has no maximum width.
   * @param key
   *        React key
   * @param style
   *        React element CSS style
   * @param text
   *        Reduce maximum width to more naturally accommodate text.
   * @param textAlign
   *        Align container text.
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
    as: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    text: js.UndefOr[Boolean] = js.undefined,
    textAlign: js.UndefOr[TextAlign] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (fluid.isDefined) {p.fluid = fluid}
    if (key.isDefined) {p.key = key}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (text.isDefined) {p.text = text}
    if (textAlign.isDefined) {p.textAlign = textAlign.map(v => v.value)}

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
        