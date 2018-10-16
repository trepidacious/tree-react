
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object TableCell {
  
  sealed trait Padding{ val value: String }

  object Padding {
    case object Default extends Padding { val value: String = "default" }
    case object Checkbox extends Padding { val value: String = "checkbox" }
    case object Dense extends Padding { val value: String = "dense" }
    case object None extends Padding { val value: String = "none" }
  }
            
  sealed trait SortDirection{ val value: String }

  object SortDirection {
    case object Asc extends SortDirection { val value: String = "asc" }
    case object Desc extends SortDirection { val value: String = "desc" }
    case object False extends SortDirection { val value: String = "false" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Head extends Variant { val value: String = "head" }
    case object Body extends Variant { val value: String = "body" }
    case object Footer extends Variant { val value: String = "footer" }
  }
          
  @js.native
  trait Props extends js.Object {
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var numeric: js.UndefOr[Boolean] = js.native
    var padding: js.UndefOr[String] = js.native
    var scope: js.UndefOr[String] = js.native
    var sortDirection: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/TableCell", JSImport.Default)
  @js.native
  object TableCellJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](TableCellJS)
  
  /**
   * 
   * @param children
   *        The table cell contents.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param key
   *        React key
   * @param numeric
   *        If `true`, content will align to the right.
   * @param padding
   *        Sets the padding applied to the cell.
   *        By default, the Table parent component set the value.
   * @param scope
   *        Set scope attribute.
   * @param sortDirection
   *        Set aria-sort direction.
   * @param style
   *        React element CSS style
   * @param variant
   *        Specify the cell type.
   *        By default, the TableHead, TableBody or TableFooter parent component set the value.
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
    key: js.UndefOr[String] = js.undefined,
    numeric: js.UndefOr[Boolean] = js.undefined,
    padding: js.UndefOr[Padding] = js.undefined,
    scope: js.UndefOr[String] = js.undefined,
    sortDirection: js.UndefOr[SortDirection] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (key.isDefined) {p.key = key}
    if (numeric.isDefined) {p.numeric = numeric}
    if (padding.isDefined) {p.padding = padding.map(v => v.value)}
    if (scope.isDefined) {p.scope = scope}
    if (sortDirection.isDefined) {p.sortDirection = sortDirection.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (variant.isDefined) {p.variant = variant.map(v => v.value)}

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
        