
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object CardHeader {
  
  @js.native
  trait Props extends js.Object {
    var action: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var avatar: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var disableTypography: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var subheader: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var subheaderTypographyProps: js.UndefOr[js.Object] = js.native
    var title: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var titleTypographyProps: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/CardHeader", JSImport.Default)
  @js.native
  object CardHeaderJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.None](CardHeaderJS)
  
  /**
   * 
   * @param action
   *        The action to display in the card header.
   * @param avatar
   *        The Avatar for the Card Header.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param disableTypography
   *        If `true`, the children won't be wrapped by a Typography component.
   *        This can be useful to render an alternative Typography variant by wrapping
   *        the `title` text, and optional `subheader` text
   *        with the Typography component.
   * @param key
   *        React key
   * @param style
   *        React element CSS style
   * @param subheader
   *        The content of the component.
   * @param subheaderTypographyProps
   *        These props will be forwarded to the subheader
   *        (as long as disableTypography is not `true`).
   * @param title
   *        The content of the Card Title.
   * @param titleTypographyProps
   *        These props will be forwarded to the title
   *        (as long as disableTypography is not `true`).
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
    action: js.UndefOr[VdomNode] = js.undefined,
    avatar: js.UndefOr[VdomNode] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    disableTypography: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    subheader: js.UndefOr[VdomNode] = js.undefined,
    subheaderTypographyProps: js.UndefOr[js.Object] = js.undefined,
    title: js.UndefOr[VdomNode] = js.undefined,
    titleTypographyProps: js.UndefOr[js.Object] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (action.isDefined) {p.action = action.map(v => v.rawNode)}
    if (avatar.isDefined) {p.avatar = avatar.map(v => v.rawNode)}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (disableTypography.isDefined) {p.disableTypography = disableTypography}
    if (key.isDefined) {p.key = key}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (subheader.isDefined) {p.subheader = subheader.map(v => v.rawNode)}
    if (subheaderTypographyProps.isDefined) {p.subheaderTypographyProps = subheaderTypographyProps}
    if (title.isDefined) {p.title = title.map(v => v.rawNode)}
    if (titleTypographyProps.isDefined) {p.titleTypographyProps = titleTypographyProps}

    additionalProps.foreach {
      a => {
        val dict = a.asInstanceOf[js.Dictionary[js.Any]]
        val pDict = p.asInstanceOf[js.Dictionary[js.Any]]
        for ((prop, value) <- dict) {
          if (!p.hasOwnProperty(prop)) pDict(prop) = value
        }
      }
    }
    
    jsComponent(p)
  }

}
        