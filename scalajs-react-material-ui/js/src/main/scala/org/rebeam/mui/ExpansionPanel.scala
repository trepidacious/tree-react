
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object ExpansionPanel {
  
  @js.native
  trait Props extends js.Object {
    var CollapseProps: js.UndefOr[js.Object] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var defaultExpanded: js.UndefOr[Boolean] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var elevation: js.UndefOr[Double] = js.native
    var expanded: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var onChange: js.UndefOr[scalajs.js.Function1[ReactEvent, Unit]] = js.native
    var square: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/ExpansionPanel", JSImport.Default)
  @js.native
  object ExpansionPanelJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](ExpansionPanelJS)
  
  /**
   * 
   * @param CollapseProps
   *        Properties applied to the [`Collapse`](/api/collapse/) element.
   * @param children
   *        The content of the expansion panel.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   *        Passed to Paper
   * @param defaultExpanded
   *        If `true`, expands the panel by default.
   * @param disabled
   *        If `true`, the panel will be displayed in a disabled state.
   * @param elevation
   *        Shadow depth, corresponds to `dp` in the spec.
   *        It's accepting values between 0 and 24 inclusive.
   *        Passed to Paper
   * @param expanded
   *        If `true`, expands the panel, otherwise collapse it.
   *        Setting this prop enables control over the panel.
   * @param key
   *        React key
   * @param onChange
   *        Callback fired when the expand/collapse state is changed.
   *        
   *        parameter {object} event The event source of the callback
   *        parameter {boolean} expanded The `expanded` state of the panel
   * @param square
   *        If `true`, rounded corners are disabled.
   *        Passed to Paper
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
    CollapseProps: js.UndefOr[js.Object] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    defaultExpanded: js.UndefOr[Boolean] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    elevation: js.UndefOr[Double] = js.undefined,
    expanded: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onChange: js.UndefOr[ReactEvent => Callback] = js.undefined,
    square: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (CollapseProps.isDefined) {p.CollapseProps = CollapseProps}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (defaultExpanded.isDefined) {p.defaultExpanded = defaultExpanded}
    if (disabled.isDefined) {p.disabled = disabled}
    if (elevation.isDefined) {p.elevation = elevation}
    if (expanded.isDefined) {p.expanded = expanded}
    if (key.isDefined) {p.key = key}
    if (onChange.isDefined) {p.onChange = onChange.map(v => (e: ReactEvent) => v(e).runNow())}
    if (square.isDefined) {p.square = square}
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
        