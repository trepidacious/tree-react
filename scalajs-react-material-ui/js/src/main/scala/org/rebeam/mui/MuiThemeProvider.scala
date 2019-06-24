
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object MuiThemeProvider {
  
  @js.native
  trait Props extends js.Object {
    var disableStylesGeneration: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var sheetsCache: js.UndefOr[js.Object] = js.native
    var sheetsManager: js.UndefOr[js.Object] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var theme: js.Any = js.native
  }

  @JSImport("@material-ui/core/styles", "MuiThemeProvider")
  @js.native
  object MuiThemeProviderJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](MuiThemeProviderJS)
  
  /**
   * This component takes a `theme` property.
   * It makes the `theme` available down the React tree thanks to React context.
   * This component should preferably be used at **the root of your component tree**.
   * @param children
   *        You can wrap a node.
   * @param disableStylesGeneration
   *        You can disable the generation of the styles with this option.
   *        It can be useful when traversing the React tree outside of the HTML
   *        rendering step on the server.
   *        Let's say you are using react-apollo to extract all
   *        the queries made by the interface server-side.
   *        You can significantly speed up the traversal with this property.
   * @param key
   *        React key
   * @param sheetsCache
   *        Property spread to root element
   *        
   *        In beta.
   * @param sheetsManager
   *        The sheetsManager is used to deduplicate style sheet injection in the page.
   *        It's deduplicating using the (theme, styles) couple.
   *        On the server, you should provide a new instance for each request.
   * @param style
   *        React element CSS style
   * @param theme
   *        A theme object.
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
    disableStylesGeneration: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    sheetsCache: js.UndefOr[js.Object] = js.undefined,
    sheetsManager: js.UndefOr[js.Object] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    theme: js.Any,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (disableStylesGeneration.isDefined) {p.disableStylesGeneration = disableStylesGeneration}
    if (key.isDefined) {p.key = key}
    if (sheetsCache.isDefined) {p.sheetsCache = sheetsCache}
    if (sheetsManager.isDefined) {p.sheetsManager = sheetsManager}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    p.theme = theme

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
        