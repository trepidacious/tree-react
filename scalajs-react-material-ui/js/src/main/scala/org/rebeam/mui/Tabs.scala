
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Tabs {
  
  sealed trait IndicatorColor{ val value: String }

  object IndicatorColor {
    case object Secondary extends IndicatorColor { val value: String = "secondary" }
    case object Primary extends IndicatorColor { val value: String = "primary" }
  }
            
  sealed trait ScrollButtons{ val value: String }

  object ScrollButtons {
    case object Auto extends ScrollButtons { val value: String = "auto" }
    case object On extends ScrollButtons { val value: String = "on" }
    case object Off extends ScrollButtons { val value: String = "off" }
  }
            
  sealed trait TextColor{ val value: String }

  object TextColor {
    case object Secondary extends TextColor { val value: String = "secondary" }
    case object Primary extends TextColor { val value: String = "primary" }
    case object Inherit extends TextColor { val value: String = "inherit" }
  }
          
  @js.native
  trait Props extends js.Object {
    var ScrollButtonComponent: js.UndefOr[js.Any] = js.native
    var TabIndicatorProps: js.UndefOr[js.Object] = js.native
    var action: js.UndefOr[js.Any] = js.native
    var centered: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var fullWidth: js.UndefOr[Boolean] = js.native
    var indicatorColor: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var onChange: js.UndefOr[scalajs.js.Function1[ReactEvent, Unit]] = js.native
    var scrollButtons: js.UndefOr[String] = js.native
    var scrollable: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var textColor: js.UndefOr[String] = js.native
    var theme: js.Object = js.native
    var value: js.UndefOr[js.Any] = js.native
  }

  @JSImport("@material-ui/core/Tabs", JSImport.Default)
  @js.native
  object TabsJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](TabsJS)
  
  /**
   * 
   * @param ScrollButtonComponent
   *        The component used to render the scroll buttons.
   * @param TabIndicatorProps
   *        Properties applied to the `TabIndicator` element.
   * @param action
   *        Callback fired when the component mounts.
   *        This is useful when you want to trigger an action programmatically.
   *        It currently only supports `updateIndicator()` action.
   *        
   *        parameter {object} actions This object contains all possible actions
   *        that can be triggered programmatically.
   * @param centered
   *        If `true`, the tabs will be centered.
   *        This property is intended for large views.
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
   * @param fullWidth
   *        If `true`, the tabs will grow to use all the available space.
   *        This property is intended for small views, like on mobile.
   * @param indicatorColor
   *        Determines the color of the indicator.
   * @param key
   *        React key
   * @param onChange
   *        Callback fired when the value changes.
   *        
   *        parameter {object} event The event source of the callback
   *        parameter {number} value We default to the index of the child
   * @param scrollButtons
   *        Determine behavior of scroll buttons when tabs are set to scroll
   *        `auto` will only present them on medium and larger viewports
   *        `on` will always present them
   *        `off` will never present them
   * @param scrollable
   *        True invokes scrolling properties and allow for horizontally scrolling
   *        (or swiping) the tab bar.
   * @param style
   *        React element CSS style
   * @param textColor
   *        Determines the color of the `Tab`.
   * @param theme
   *        Property spread to root element
   * @param value
   *        The value of the currently selected `Tab`.
   *        If you don't want any selected `Tab`, you can set this property to `false`.
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
    ScrollButtonComponent: js.UndefOr[js.Any] = js.undefined,
    TabIndicatorProps: js.UndefOr[js.Object] = js.undefined,
    action: js.UndefOr[js.Any] = js.undefined,
    centered: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    fullWidth: js.UndefOr[Boolean] = js.undefined,
    indicatorColor: js.UndefOr[IndicatorColor] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onChange: js.UndefOr[ReactEvent => Callback] = js.undefined,
    scrollButtons: js.UndefOr[ScrollButtons] = js.undefined,
    scrollable: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    textColor: js.UndefOr[TextColor] = js.undefined,
    theme: js.Object,
    value: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (ScrollButtonComponent.isDefined) {p.ScrollButtonComponent = ScrollButtonComponent}
    if (TabIndicatorProps.isDefined) {p.TabIndicatorProps = TabIndicatorProps}
    if (action.isDefined) {p.action = action}
    if (centered.isDefined) {p.centered = centered}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (fullWidth.isDefined) {p.fullWidth = fullWidth}
    if (indicatorColor.isDefined) {p.indicatorColor = indicatorColor.map(v => v.value)}
    if (key.isDefined) {p.key = key}
    if (onChange.isDefined) {p.onChange = onChange.map(v => (e: ReactEvent) => v(e).runNow())}
    if (scrollButtons.isDefined) {p.scrollButtons = scrollButtons.map(v => v.value)}
    if (scrollable.isDefined) {p.scrollable = scrollable}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (textColor.isDefined) {p.textColor = textColor.map(v => v.value)}
    p.theme = theme
    if (value.isDefined) {p.value = value}

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
        