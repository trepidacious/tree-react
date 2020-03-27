
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

// import japgolly.scalajs.react.vdom.html_<^._

object AccordionPanel {
  
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var index: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var onTitleClick: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var title: js.UndefOr[js.Any] = js.native
  }

  @JSImport("semantic-ui-react", "AccordionPanel")
  @js.native
  object AccordionPanelJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](AccordionPanelJS)
  
  /**
   * A panel sub-component for Accordion component.
   * @param active
   *        Whether or not the title is in the open state.
   * @param content
   *        A shorthand for Accordion.Content.
   * @param index
   *        A panel index.
   * @param key
   *        React key
   * @param onTitleClick
   *        Called when a panel title is clicked.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All item props.
   * @param style
   *        React element CSS style
   * @param title
   *        A shorthand for Accordion.Title.
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
    active: js.UndefOr[Boolean] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    index: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onTitleClick: js.UndefOr[Callback] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    title: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (content.isDefined) {p.content = content}
    if (index.isDefined) {p.index = index}
    if (key.isDefined) {p.key = key}
    if (onTitleClick.isDefined) {p.onTitleClick = onTitleClick.map(v => v.toJsFn)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (title.isDefined) {p.title = title}

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
        