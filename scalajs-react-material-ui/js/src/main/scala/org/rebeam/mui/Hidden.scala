
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Hidden {
  
  sealed trait Implementation{ val value: String }

  object Implementation {
    case object Js extends Implementation { val value: String = "js" }
    case object Css extends Implementation { val value: String = "css" }
  }
            
  sealed trait InitialWidth{ val value: String }

  object InitialWidth {
    case object Xs extends InitialWidth { val value: String = "xs" }
    case object Xl extends InitialWidth { val value: String = "xl" }
    case object Md extends InitialWidth { val value: String = "md" }
    case object Sm extends InitialWidth { val value: String = "sm" }
    case object Lg extends InitialWidth { val value: String = "lg" }
  }
          
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var implementation: js.UndefOr[String] = js.native
    var initialWidth: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var lgDown: js.UndefOr[Boolean] = js.native
    var lgUp: js.UndefOr[Boolean] = js.native
    var mdDown: js.UndefOr[Boolean] = js.native
    var mdUp: js.UndefOr[Boolean] = js.native
    var only: js.UndefOr[js.Any] = js.native
    var smDown: js.UndefOr[Boolean] = js.native
    var smUp: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var xlDown: js.UndefOr[Boolean] = js.native
    var xlUp: js.UndefOr[Boolean] = js.native
    var xsDown: js.UndefOr[Boolean] = js.native
    var xsUp: js.UndefOr[Boolean] = js.native
  }

  @JSImport("@material-ui/core/Hidden", JSImport.Default)
  @js.native
  object HiddenJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](HiddenJS)
  
  /**
   * Responsively hides children based on the selected implementation.
   * @param children
   *        The content of the component.
   * @param className
   *        Property spread to root element
   * @param implementation
   *        Specify which implementation to use.  'js' is the default, 'css' works better for
   *        server-side rendering.
   * @param initialWidth
   *        You can use this property when choosing the `js` implementation with server-side rendering.
   *        
   *        As `window.innerWidth` is unavailable on the server,
   *        we default to rendering an empty componenent during the first mount.
   *        You might want to use an heristic to approximate
   *        the screen width of the client browser screen width.
   *        
   *        For instance, you could be using the user-agent or the client-hints.
   *        https://caniuse.com/#search=client%20hint
   * @param key
   *        React key
   * @param lgDown
   *        If true, screens this size and down will be hidden.
   * @param lgUp
   *        If true, screens this size and up will be hidden.
   * @param mdDown
   *        If true, screens this size and down will be hidden.
   * @param mdUp
   *        If true, screens this size and up will be hidden.
   * @param only
   *        Hide the given breakpoint(s).
   * @param smDown
   *        If true, screens this size and down will be hidden.
   * @param smUp
   *        If true, screens this size and up will be hidden.
   * @param style
   *        React element CSS style
   * @param xlDown
   *        If true, screens this size and down will be hidden.
   * @param xlUp
   *        If true, screens this size and up will be hidden.
   * @param xsDown
   *        If true, screens this size and down will be hidden.
   * @param xsUp
   *        If true, screens this size and up will be hidden.
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
    className: js.UndefOr[String] = js.undefined,
    implementation: js.UndefOr[Implementation] = js.undefined,
    initialWidth: js.UndefOr[InitialWidth] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    lgDown: js.UndefOr[Boolean] = js.undefined,
    lgUp: js.UndefOr[Boolean] = js.undefined,
    mdDown: js.UndefOr[Boolean] = js.undefined,
    mdUp: js.UndefOr[Boolean] = js.undefined,
    only: js.UndefOr[js.Any] = js.undefined,
    smDown: js.UndefOr[Boolean] = js.undefined,
    smUp: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    xlDown: js.UndefOr[Boolean] = js.undefined,
    xlUp: js.UndefOr[Boolean] = js.undefined,
    xsDown: js.UndefOr[Boolean] = js.undefined,
    xsUp: js.UndefOr[Boolean] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (implementation.isDefined) {p.implementation = implementation.map(v => v.value)}
    if (initialWidth.isDefined) {p.initialWidth = initialWidth.map(v => v.value)}
    if (key.isDefined) {p.key = key}
    if (lgDown.isDefined) {p.lgDown = lgDown}
    if (lgUp.isDefined) {p.lgUp = lgUp}
    if (mdDown.isDefined) {p.mdDown = mdDown}
    if (mdUp.isDefined) {p.mdUp = mdUp}
    if (only.isDefined) {p.only = only}
    if (smDown.isDefined) {p.smDown = smDown}
    if (smUp.isDefined) {p.smUp = smUp}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (xlDown.isDefined) {p.xlDown = xlDown}
    if (xlUp.isDefined) {p.xlUp = xlUp}
    if (xsDown.isDefined) {p.xsDown = xsDown}
    if (xsUp.isDefined) {p.xsUp = xsUp}

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
        