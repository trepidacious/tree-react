
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Grid {
  
  sealed trait AlignContent{ val value: String }

  object AlignContent {
    case object SpaceBetween extends AlignContent { val value: String = "space-between" }
    case object FlexStart extends AlignContent { val value: String = "flex-start" }
    case object FlexEnd extends AlignContent { val value: String = "flex-end" }
    case object Center extends AlignContent { val value: String = "center" }
    case object Stretch extends AlignContent { val value: String = "stretch" }
    case object SpaceAround extends AlignContent { val value: String = "space-around" }
  }
            
  sealed trait AlignItems{ val value: String }

  object AlignItems {
    case object FlexEnd extends AlignItems { val value: String = "flex-end" }
    case object Stretch extends AlignItems { val value: String = "stretch" }
    case object Center extends AlignItems { val value: String = "center" }
    case object FlexStart extends AlignItems { val value: String = "flex-start" }
    case object Baseline extends AlignItems { val value: String = "baseline" }
  }
            
  sealed trait Direction{ val value: String }

  object Direction {
    case object Row extends Direction { val value: String = "row" }
    case object RowReverse extends Direction { val value: String = "row-reverse" }
    case object Column extends Direction { val value: String = "column" }
    case object ColumnReverse extends Direction { val value: String = "column-reverse" }
  }
            
  sealed trait Justify{ val value: String }

  object Justify {
    case object Center extends Justify { val value: String = "center" }
    case object SpaceBetween extends Justify { val value: String = "space-between" }
    case object FlexStart extends Justify { val value: String = "flex-start" }
    case object FlexEnd extends Justify { val value: String = "flex-end" }
    case object SpaceAround extends Justify { val value: String = "space-around" }
    case object SpaceEvenly extends Justify { val value: String = "space-evenly" }
  }
            
  sealed trait Lg{ val value: String }

  object Lg {
    case object _5 extends Lg { val value: String = "5" }
    case object _11 extends Lg { val value: String = "11" }
    case object _2 extends Lg { val value: String = "2" }
    case object _6 extends Lg { val value: String = "6" }
    case object False extends Lg { val value: String = "false" }
    case object Auto extends Lg { val value: String = "auto" }
    case object _4 extends Lg { val value: String = "4" }
    case object _3 extends Lg { val value: String = "3" }
    case object _8 extends Lg { val value: String = "8" }
    case object _12 extends Lg { val value: String = "12" }
    case object _10 extends Lg { val value: String = "10" }
    case object _7 extends Lg { val value: String = "7" }
    case object True extends Lg { val value: String = "true" }
    case object _9 extends Lg { val value: String = "9" }
    case object _1 extends Lg { val value: String = "1" }
  }
            
  sealed trait Md{ val value: String }

  object Md {
    case object Auto extends Md { val value: String = "auto" }
    case object _12 extends Md { val value: String = "12" }
    case object _1 extends Md { val value: String = "1" }
    case object _11 extends Md { val value: String = "11" }
    case object True extends Md { val value: String = "true" }
    case object _7 extends Md { val value: String = "7" }
    case object _8 extends Md { val value: String = "8" }
    case object _4 extends Md { val value: String = "4" }
    case object _10 extends Md { val value: String = "10" }
    case object False extends Md { val value: String = "false" }
    case object _2 extends Md { val value: String = "2" }
    case object _6 extends Md { val value: String = "6" }
    case object _3 extends Md { val value: String = "3" }
    case object _9 extends Md { val value: String = "9" }
    case object _5 extends Md { val value: String = "5" }
  }
            
  sealed trait Sm{ val value: String }

  object Sm {
    case object True extends Sm { val value: String = "true" }
    case object _3 extends Sm { val value: String = "3" }
    case object _4 extends Sm { val value: String = "4" }
    case object _2 extends Sm { val value: String = "2" }
    case object False extends Sm { val value: String = "false" }
    case object _7 extends Sm { val value: String = "7" }
    case object _12 extends Sm { val value: String = "12" }
    case object _10 extends Sm { val value: String = "10" }
    case object _1 extends Sm { val value: String = "1" }
    case object Auto extends Sm { val value: String = "auto" }
    case object _6 extends Sm { val value: String = "6" }
    case object _9 extends Sm { val value: String = "9" }
    case object _5 extends Sm { val value: String = "5" }
    case object _11 extends Sm { val value: String = "11" }
    case object _8 extends Sm { val value: String = "8" }
  }
            
  sealed trait Spacing{ val value: String }

  object Spacing {
    case object _0 extends Spacing { val value: String = "0" }
    case object _24 extends Spacing { val value: String = "24" }
    case object _16 extends Spacing { val value: String = "16" }
    case object _32 extends Spacing { val value: String = "32" }
    case object _8 extends Spacing { val value: String = "8" }
    case object _40 extends Spacing { val value: String = "40" }
  }
            
  sealed trait Wrap{ val value: String }

  object Wrap {
    case object Nowrap extends Wrap { val value: String = "nowrap" }
    case object Wrap extends Wrap { val value: String = "wrap" }
    case object WrapReverse extends Wrap { val value: String = "wrap-reverse" }
  }
            
  sealed trait Xl{ val value: String }

  object Xl {
    case object _10 extends Xl { val value: String = "10" }
    case object _8 extends Xl { val value: String = "8" }
    case object Auto extends Xl { val value: String = "auto" }
    case object _3 extends Xl { val value: String = "3" }
    case object _1 extends Xl { val value: String = "1" }
    case object _12 extends Xl { val value: String = "12" }
    case object _4 extends Xl { val value: String = "4" }
    case object _2 extends Xl { val value: String = "2" }
    case object _6 extends Xl { val value: String = "6" }
    case object True extends Xl { val value: String = "true" }
    case object _11 extends Xl { val value: String = "11" }
    case object False extends Xl { val value: String = "false" }
    case object _7 extends Xl { val value: String = "7" }
    case object _5 extends Xl { val value: String = "5" }
    case object _9 extends Xl { val value: String = "9" }
  }
            
  sealed trait Xs{ val value: String }

  object Xs {
    case object _11 extends Xs { val value: String = "11" }
    case object _2 extends Xs { val value: String = "2" }
    case object False extends Xs { val value: String = "false" }
    case object _7 extends Xs { val value: String = "7" }
    case object _10 extends Xs { val value: String = "10" }
    case object _1 extends Xs { val value: String = "1" }
    case object _3 extends Xs { val value: String = "3" }
    case object _5 extends Xs { val value: String = "5" }
    case object _9 extends Xs { val value: String = "9" }
    case object _4 extends Xs { val value: String = "4" }
    case object True extends Xs { val value: String = "true" }
    case object _12 extends Xs { val value: String = "12" }
    case object _6 extends Xs { val value: String = "6" }
    case object Auto extends Xs { val value: String = "auto" }
    case object _8 extends Xs { val value: String = "8" }
  }
          
  @js.native
  trait Props extends js.Object {
    var alignContent: js.UndefOr[String] = js.native
    var alignItems: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var container: js.UndefOr[Boolean] = js.native
    var direction: js.UndefOr[String] = js.native
    var item: js.UndefOr[Boolean] = js.native
    var justify: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var lg: js.UndefOr[String] = js.native
    var md: js.UndefOr[String] = js.native
    var sm: js.UndefOr[String] = js.native
    var spacing: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var wrap: js.UndefOr[String] = js.native
    var xl: js.UndefOr[String] = js.native
    var xs: js.UndefOr[String] = js.native
    var zeroMinWidth: js.UndefOr[Boolean] = js.native
  }

  @JSImport("@material-ui/core/Grid", JSImport.Default)
  @js.native
  object GridJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](GridJS)
  
  /**
   * 
   * @param alignContent
   *        Defines the `align-content` style property.
   *        It's applied for all screen sizes.
   * @param alignItems
   *        Defines the `align-items` style property.
   *        It's applied for all screen sizes.
   * @param children
   *        The content of the component.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   * @param container
   *        If `true`, the component will have the flex *container* behavior.
   *        You should be wrapping *items* with a *container*.
   * @param direction
   *        Defines the `flex-direction` style property.
   *        It is applied for all screen sizes.
   * @param item
   *        If `true`, the component will have the flex *item* behavior.
   *        You should be wrapping *items* with a *container*.
   * @param justify
   *        Defines the `justify-content` style property.
   *        It is applied for all screen sizes.
   * @param key
   *        React key
   * @param lg
   *        Defines the number of grids the component is going to use.
   *        It's applied for the `lg` breakpoint and wider screens if not overridden.
   * @param md
   *        Defines the number of grids the component is going to use.
   *        It's applied for the `md` breakpoint and wider screens if not overridden.
   * @param sm
   *        Defines the number of grids the component is going to use.
   *        It's applied for the `sm` breakpoint and wider screens if not overridden.
   * @param spacing
   *        Defines the space between the type `item` component.
   *        It can only be used on a type `container` component.
   * @param style
   *        React element CSS style
   * @param wrap
   *        Defines the `flex-wrap` style property.
   *        It's applied for all screen sizes.
   * @param xl
   *        Defines the number of grids the component is going to use.
   *        It's applied for the `xl` breakpoint and wider screens.
   * @param xs
   *        Defines the number of grids the component is going to use.
   *        It's applied for all the screen sizes with the lowest priority.
   * @param zeroMinWidth
   *        If `true`, it sets `min-width: 0` on the item.
   *        Refer to the limitations section of the documentation to better understand the use case.
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
    alignContent: js.UndefOr[AlignContent] = js.undefined,
    alignItems: js.UndefOr[AlignItems] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    container: js.UndefOr[Boolean] = js.undefined,
    direction: js.UndefOr[Direction] = js.undefined,
    item: js.UndefOr[Boolean] = js.undefined,
    justify: js.UndefOr[Justify] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    lg: js.UndefOr[Lg] = js.undefined,
    md: js.UndefOr[Md] = js.undefined,
    sm: js.UndefOr[Sm] = js.undefined,
    spacing: js.UndefOr[Spacing] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    wrap: js.UndefOr[Wrap] = js.undefined,
    xl: js.UndefOr[Xl] = js.undefined,
    xs: js.UndefOr[Xs] = js.undefined,
    zeroMinWidth: js.UndefOr[Boolean] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (alignContent.isDefined) {p.alignContent = alignContent.map(v => v.value)}
    if (alignItems.isDefined) {p.alignItems = alignItems.map(v => v.value)}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (container.isDefined) {p.container = container}
    if (direction.isDefined) {p.direction = direction.map(v => v.value)}
    if (item.isDefined) {p.item = item}
    if (justify.isDefined) {p.justify = justify.map(v => v.value)}
    if (key.isDefined) {p.key = key}
    if (lg.isDefined) {p.lg = lg.map(v => v.value)}
    if (md.isDefined) {p.md = md.map(v => v.value)}
    if (sm.isDefined) {p.sm = sm.map(v => v.value)}
    if (spacing.isDefined) {p.spacing = spacing.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (wrap.isDefined) {p.wrap = wrap.map(v => v.value)}
    if (xl.isDefined) {p.xl = xl.map(v => v.value)}
    if (xs.isDefined) {p.xs = xs.map(v => v.value)}
    if (zeroMinWidth.isDefined) {p.zeroMinWidth = zeroMinWidth}

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
        