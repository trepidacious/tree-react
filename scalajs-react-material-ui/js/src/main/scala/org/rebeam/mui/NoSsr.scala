
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object NoSsr {
  
  @js.native
  trait Props extends js.Object {
    var defer: js.UndefOr[Boolean] = js.native
    var fallback: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var key: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/NoSsr", JSImport.Default)
  @js.native
  object NoSsrJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](NoSsrJS)
  
  /**
   * NoSsr purposely removes components from the subject of Server Side Rendering (SSR).
   * 
   * This component can be useful in a variety of situations:
   * - Escape hatch for broken dependencies not supporting SSR.
   * - Improve the time-to-first paint on the client by only rendering above the fold.
   * - Reduce the rendering time on the server.
   * - Under too heavy server load, you can turn on service degradation.
   * @param children
   *        
   * @param defer
   *        If `true`, the component will not only prevent server-side rendering.
   *        It will also defer the rendering of the children into a different screen frame.
   * @param fallback
   *        The fallback content to display.
   * @param key
   *        React key
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
    defer: js.UndefOr[Boolean] = js.undefined,
    fallback: js.UndefOr[VdomNode] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (defer.isDefined) {p.defer = defer}
    if (fallback.isDefined) {p.fallback = fallback.map(v => v.rawNode)}
    if (key.isDefined) {p.key = key}
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
        