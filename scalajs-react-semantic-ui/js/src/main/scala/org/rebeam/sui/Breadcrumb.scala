
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Breadcrumb {
  
  sealed trait Size{ val value: String }

  object Size {
    case object Mini extends Size { val value: String = "mini" }
    case object Tiny extends Size { val value: String = "tiny" }
    case object Massive extends Size { val value: String = "massive" }
    case object Small extends Size { val value: String = "small" }
    case object Big extends Size { val value: String = "big" }
    case object Huge extends Size { val value: String = "huge" }
    case object Large extends Size { val value: String = "large" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var divider: js.UndefOr[js.Any] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var sections: js.UndefOr[js.Any] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "Breadcrumb")
  @js.native
  object BreadcrumbJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](BreadcrumbJS)
  
  /**
   * A breadcrumb is used to show hierarchy between content.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param divider
   *        Shorthand for primary content of the Breadcrumb.Divider.
   * @param icon
   *        For use with the sections prop. Render as an `Icon` component with `divider` class instead of a `div` in
   *         Breadcrumb.Divider.
   * @param key
   *        React key
   * @param sections
   *        Shorthand array of props for Breadcrumb.Section.
   * @param size
   *        Size of Breadcrumb.
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
    className: js.UndefOr[String] = js.undefined,
    divider: js.UndefOr[js.Any] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    sections: js.UndefOr[js.Any] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (divider.isDefined) {p.divider = divider}
    if (icon.isDefined) {p.icon = icon}
    if (key.isDefined) {p.key = key}
    if (sections.isDefined) {p.sections = sections}
    if (size.isDefined) {p.size = size.map(v => v.value)}
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
        