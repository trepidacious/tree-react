
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Divider {
  
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var clearing: js.UndefOr[Boolean] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var fitted: js.UndefOr[Boolean] = js.native
    var hidden: js.UndefOr[Boolean] = js.native
    var horizontal: js.UndefOr[Boolean] = js.native
    var inverted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var section: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var vertical: js.UndefOr[Boolean] = js.native
  }

  @JSImport("semantic-ui-react", "Divider")
  @js.native
  object DividerJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](DividerJS)
  
  /**
   * A divider visually segments content into groups.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param clearing
   *        Divider can clear the content above it.
   * @param content
   *        Shorthand for primary content.
   * @param fitted
   *        Divider can be fitted without any space above or below it.
   * @param hidden
   *        Divider can divide content without creating a dividing line.
   * @param horizontal
   *        Divider can segment content horizontally.
   * @param inverted
   *        Divider can have its colours inverted.
   * @param key
   *        React key
   * @param section
   *        Divider can provide greater margins to divide sections of content.
   * @param style
   *        React element CSS style
   * @param vertical
   *        Divider can segment content vertically.
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
    clearing: js.UndefOr[Boolean] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    fitted: js.UndefOr[Boolean] = js.undefined,
    hidden: js.UndefOr[Boolean] = js.undefined,
    horizontal: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    section: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (clearing.isDefined) {p.clearing = clearing}
    if (content.isDefined) {p.content = content}
    if (fitted.isDefined) {p.fitted = fitted}
    if (hidden.isDefined) {p.hidden = hidden}
    if (horizontal.isDefined) {p.horizontal = horizontal}
    if (inverted.isDefined) {p.inverted = inverted}
    if (key.isDefined) {p.key = key}
    if (section.isDefined) {p.section = section}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (vertical.isDefined) {p.vertical = vertical}

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
        