
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object GridList {
  
  @js.native
  trait Props extends js.Object {
    var cellHeight: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var cols: js.UndefOr[Double] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var spacing: js.UndefOr[Double] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/GridList", JSImport.Default)
  @js.native
  object GridListJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](GridListJS)
  
  /**
   * 
   * @param cellHeight
   *        Number of px for one cell height.
   *        You can set `'auto'` if you want to let the children determine the height.
   * @param children
   *        Grid Tiles that will be in Grid List.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param cols
   *        Number of columns.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param key
   *        React key
   * @param spacing
   *        Number of px for the spacing between tiles.
   * @param style
   *        Property spread to root element
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
    cellHeight: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    cols: js.UndefOr[Double] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    spacing: js.UndefOr[Double] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (cellHeight.isDefined) {p.cellHeight = cellHeight}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (cols.isDefined) {p.cols = cols}
    if (component.isDefined) {p.component = component}
    if (key.isDefined) {p.key = key}
    if (spacing.isDefined) {p.spacing = spacing}
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
        