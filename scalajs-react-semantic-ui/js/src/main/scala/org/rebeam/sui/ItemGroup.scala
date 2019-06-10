
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object ItemGroup {
  
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var divided: js.UndefOr[Boolean] = js.native
    var items: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var link: js.UndefOr[Boolean] = js.native
    var relaxed: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var unstackable: js.UndefOr[Boolean] = js.native
  }

  @JSImport("semantic-ui-react", "ItemGroup")
  @js.native
  object ItemGroupJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](ItemGroupJS)
  
  /**
   * A group of items.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param divided
   *        Items can be divided to better distinguish between grouped content.
   * @param items
   *        Shorthand array of props for Item.
   * @param key
   *        React key
   * @param link
   *        An item can be formatted so that the entire contents link to another page.
   * @param relaxed
   *        A group of items can relax its padding to provide more negative space.
   * @param style
   *        React element CSS style
   * @param unstackable
   *        Prevent items from stacking on mobile.
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
    as: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    divided: js.UndefOr[Boolean] = js.undefined,
    items: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    link: js.UndefOr[Boolean] = js.undefined,
    relaxed: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    unstackable: js.UndefOr[Boolean] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (divided.isDefined) {p.divided = divided}
    if (items.isDefined) {p.items = items}
    if (key.isDefined) {p.key = key}
    if (link.isDefined) {p.link = link}
    if (relaxed.isDefined) {p.relaxed = relaxed}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (unstackable.isDefined) {p.unstackable = unstackable}

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
        