
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object ListItemText {
  
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var disableTypography: js.UndefOr[Boolean] = js.native
    var inset: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var primary: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var primaryTypographyProps: js.UndefOr[js.Object] = js.native
    var secondary: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var secondaryTypographyProps: js.UndefOr[js.Object] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/ListItemText", JSImport.Default)
  @js.native
  object ListItemTextJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](ListItemTextJS)
  
  /**
   * 
   * @param children
   *        Alias for the `primary` property.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param disableTypography
   *        If `true`, the children won't be wrapped by a Typography component.
   *        This can be useful to render an alternative Typography variant by wrapping
   *        the `children` (or `primary`) text, and optional `secondary` text
   *        with the Typography component.
   * @param inset
   *        If `true`, the children will be indented.
   *        This should be used if there is no left avatar or left icon.
   * @param key
   *        React key
   * @param primary
   *        The main content element.
   * @param primaryTypographyProps
   *        These props will be forwarded to the primary typography component
   *        (as long as disableTypography is not `true`).
   * @param secondary
   *        The secondary content element.
   * @param secondaryTypographyProps
   *        These props will be forwarded to the secondary typography component
   *        (as long as disableTypography is not `true`).
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
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    disableTypography: js.UndefOr[Boolean] = js.undefined,
    inset: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    primary: js.UndefOr[VdomNode] = js.undefined,
    primaryTypographyProps: js.UndefOr[js.Object] = js.undefined,
    secondary: js.UndefOr[VdomNode] = js.undefined,
    secondaryTypographyProps: js.UndefOr[js.Object] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (disableTypography.isDefined) {p.disableTypography = disableTypography}
    if (inset.isDefined) {p.inset = inset}
    if (key.isDefined) {p.key = key}
    if (primary.isDefined) {p.primary = primary.map(v => v.rawNode)}
    if (primaryTypographyProps.isDefined) {p.primaryTypographyProps = primaryTypographyProps}
    if (secondary.isDefined) {p.secondary = secondary.map(v => v.rawNode)}
    if (secondaryTypographyProps.isDefined) {p.secondaryTypographyProps = secondaryTypographyProps}
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
        