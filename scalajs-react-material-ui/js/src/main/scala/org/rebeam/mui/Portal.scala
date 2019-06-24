
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Portal {
  
  @js.native
  trait Props extends js.Object {
    var container: js.UndefOr[js.Any] = js.native
    var disablePortal: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var onRendered: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/Portal", JSImport.Default)
  @js.native
  object PortalJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](PortalJS)
  
  /**
   * Portals provide a first-class way to render children into a DOM node
   * that exists outside the DOM hierarchy of the parent component.
   * @param children
   *        The children to render into the `container`.
   * @param container
   *        A node, component instance, or function that returns either.
   *        The `container` will have the portal children appended to it.
   *        By default, it uses the body of the top-level document object,
   *        so it's simply `document.body` most of the time.
   * @param disablePortal
   *        Disable the portal behavior.
   *        The children stay within it's parent DOM hierarchy.
   * @param key
   *        React key
   * @param onRendered
   *        Callback fired once the children has been mounted into the `container`.
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
    container: js.UndefOr[js.Any] = js.undefined,
    disablePortal: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onRendered: js.UndefOr[Callback] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (container.isDefined) {p.container = container}
    if (disablePortal.isDefined) {p.disablePortal = disablePortal}
    if (key.isDefined) {p.key = key}
    if (onRendered.isDefined) {p.onRendered = onRendered.map(v => v.toJsFn)}
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
        