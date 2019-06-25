
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Responsive {
  
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var fireOnMount: js.UndefOr[Boolean] = js.native
    var getWidth: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var maxWidth: js.UndefOr[js.Any] = js.native
    var minWidth: js.UndefOr[js.Any] = js.native
    var onUpdate: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "Responsive")
  @js.native
  object ResponsiveJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](ResponsiveJS)
  
  /**
   * Responsive can control visibility of content.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param fireOnMount
   *        Fires callbacks immediately after mount.
   * @param getWidth
   *        Called to get width of screen. Defaults to using `window.innerWidth` when in a browser;
   *        otherwise, assumes a width of 0.
   * @param key
   *        React key
   * @param maxWidth
   *        The maximum width at which content will be displayed.
   * @param minWidth
   *        The minimum width at which content will be displayed.
   * @param onUpdate
   *        Called on update.
   *        
   *        parameter {SyntheticEvent} event - The React SyntheticEvent object
   *        parameter {object} data - All props and the event value.
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
    fireOnMount: js.UndefOr[Boolean] = js.undefined,
    getWidth: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    maxWidth: js.UndefOr[js.Any] = js.undefined,
    minWidth: js.UndefOr[js.Any] = js.undefined,
    onUpdate: js.UndefOr[Callback] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (fireOnMount.isDefined) {p.fireOnMount = fireOnMount}
    if (getWidth.isDefined) {p.getWidth = getWidth}
    if (key.isDefined) {p.key = key}
    if (maxWidth.isDefined) {p.maxWidth = maxWidth}
    if (minWidth.isDefined) {p.minWidth = minWidth}
    if (onUpdate.isDefined) {p.onUpdate = onUpdate.map(v => v.toJsFn)}
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
        