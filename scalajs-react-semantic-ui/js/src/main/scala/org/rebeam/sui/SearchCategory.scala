
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object SearchCategory {
  
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var name: js.UndefOr[String] = js.native
    var renderer: js.UndefOr[js.Any] = js.native
    var results: js.UndefOr[List[js.Any]] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "SearchCategory")
  @js.native
  object SearchCategoryJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](SearchCategoryJS)
  
  /**
   * 
   * @param active
   *        The item currently selected by keyboard shortcut.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param key
   *        React key
   * @param name
   *        Display name.
   * @param renderer
   *        Renders the category contents.
   *        
   *        parameter {object} props - The SearchCategory props object.
   *        returns {*} - Renderable category contents.
   * @param results
   *        Array of Search.Result props.
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
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    name: js.UndefOr[String] = js.undefined,
    renderer: js.UndefOr[js.Any] = js.undefined,
    results: js.UndefOr[List[js.Any]] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (key.isDefined) {p.key = key}
    if (name.isDefined) {p.name = name}
    if (renderer.isDefined) {p.renderer = renderer}
    if (results.isDefined) {p.results = results}
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
        