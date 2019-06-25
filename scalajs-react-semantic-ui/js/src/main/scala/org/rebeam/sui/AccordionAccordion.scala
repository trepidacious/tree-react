
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object AccordionAccordion {
  
  @js.native
  trait Props extends js.Object {
    var activeIndex: js.UndefOr[js.Any] = js.native
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var defaultActiveIndex: js.UndefOr[js.Any] = js.native
    var exclusive: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var onTitleClick: js.UndefOr[js.Any] = js.native
    var panels: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "AccordionAccordion")
  @js.native
  object AccordionAccordionJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](AccordionAccordionJS)
  
  /**
   * An Accordion can contain sub-accordions.
   * @param activeIndex
   *        Index of the currently active panel.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param defaultActiveIndex
   *        Initial activeIndex value.
   * @param exclusive
   *        Only allow one panel open at a time.
   * @param key
   *        React key
   * @param onTitleClick
   *        Called when a panel title is clicked.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All item props.
   * @param panels
   *        Shorthand array of props for Accordion.
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
    activeIndex: js.UndefOr[js.Any] = js.undefined,
    as: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    defaultActiveIndex: js.UndefOr[js.Any] = js.undefined,
    exclusive: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onTitleClick: js.UndefOr[js.Any] = js.undefined,
    panels: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (activeIndex.isDefined) {p.activeIndex = activeIndex}
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (defaultActiveIndex.isDefined) {p.defaultActiveIndex = defaultActiveIndex}
    if (exclusive.isDefined) {p.exclusive = exclusive}
    if (key.isDefined) {p.key = key}
    if (onTitleClick.isDefined) {p.onTitleClick = onTitleClick}
    if (panels.isDefined) {p.panels = panels}
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
        