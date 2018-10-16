
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object GridListTile {
  
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var cols: js.UndefOr[Double] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var rows: js.UndefOr[Double] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/GridListTile", JSImport.Default)
  @js.native
  object GridListTileJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](GridListTileJS)
  
  /**
   * 
   * @param children
   *        Theoretically you can pass any node as children, but the main use case is to pass an img,
   *        in which case GridListTile takes care of making the image "cover" available space
   *        (similar to `background-size: cover` or to `object-fit: cover`).
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param cols
   *        Width of the tile in number of grid cells.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param key
   *        React key
   * @param rows
   *        Height of the tile in number of grid cells.
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
    cols: js.UndefOr[Double] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    rows: js.UndefOr[Double] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (cols.isDefined) {p.cols = cols}
    if (component.isDefined) {p.component = component}
    if (key.isDefined) {p.key = key}
    if (rows.isDefined) {p.rows = rows}
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
        