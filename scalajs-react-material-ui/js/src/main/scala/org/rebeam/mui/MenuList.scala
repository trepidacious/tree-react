
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object MenuList {
  
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var dense: js.UndefOr[Boolean] = js.native
    var disablePadding: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var onBlur: js.UndefOr[scalajs.js.Function1[ReactFocusEvent, Unit]] = js.native
    var onKeyDown: js.UndefOr[scalajs.js.Function1[ReactKeyboardEvent, Unit]] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var subheader: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
  }

  @JSImport("@material-ui/core/MenuList", JSImport.Default)
  @js.native
  object MenuListJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](MenuListJS)
  
  /**
   * 
   * @param children
   *        MenuList contents, normally `MenuItem`s.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   *        Passed to List
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   *        Passed to List
   * @param dense
   *        If `true`, compact vertical padding designed for keyboard and mouse input will be used for
   *        the list and list items. The property is available to descendant components as the
   *        `dense` context.
   *        Passed to List
   * @param disablePadding
   *        If `true`, vertical padding will be removed from the list.
   *        Passed to List
   * @param key
   *        React key
   * @param onBlur
   *        Property spread to root element
   * @param onKeyDown
   *        Property spread to root element
   * @param style
   *        React element CSS style
   * @param subheader
   *        The content of the subheader, normally `ListSubheader`.
   *        Passed to List
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
    component: js.UndefOr[js.Any] = js.undefined,
    dense: js.UndefOr[Boolean] = js.undefined,
    disablePadding: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onBlur: js.UndefOr[ReactFocusEvent => Callback] = js.undefined,
    onKeyDown: js.UndefOr[ReactKeyboardEvent => Callback] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    subheader: js.UndefOr[VdomNode] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (dense.isDefined) {p.dense = dense}
    if (disablePadding.isDefined) {p.disablePadding = disablePadding}
    if (key.isDefined) {p.key = key}
    if (onBlur.isDefined) {p.onBlur = onBlur.map(v => (e: ReactFocusEvent) => v(e).runNow())}
    if (onKeyDown.isDefined) {p.onKeyDown = onKeyDown.map(v => (e: ReactKeyboardEvent) => v(e).runNow())}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (subheader.isDefined) {p.subheader = subheader.map(v => v.rawNode)}

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
        