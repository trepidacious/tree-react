
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object SegmentGroup {
  
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
    var as: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var compact: js.UndefOr[Boolean] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var horizontal: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var piled: js.UndefOr[Boolean] = js.native
    var raised: js.UndefOr[Boolean] = js.native
    var size: js.UndefOr[String] = js.native
    var stacked: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "SegmentGroup")
  @js.native
  object SegmentGroupJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](SegmentGroupJS)
  
  /**
   * A group of segments can be formatted to appear together.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param compact
   *        A segment may take up only as much space as is necessary.
   * @param content
   *        Shorthand for primary content.
   * @param horizontal
   *        Formats content to be aligned horizontally.
   * @param key
   *        React key
   * @param piled
   *        Formatted to look like a pile of pages.
   * @param raised
   *        A segment group may be formatted to raise above the page.
   * @param size
   *        A segment group can have different sizes.
   * @param stacked
   *        Formatted to show it contains multiple pages.
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
    as: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    compact: js.UndefOr[Boolean] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    horizontal: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    piled: js.UndefOr[Boolean] = js.undefined,
    raised: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    stacked: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (compact.isDefined) {p.compact = compact}
    if (content.isDefined) {p.content = content}
    if (horizontal.isDefined) {p.horizontal = horizontal}
    if (key.isDefined) {p.key = key}
    if (piled.isDefined) {p.piled = piled}
    if (raised.isDefined) {p.raised = raised}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (stacked.isDefined) {p.stacked = stacked}
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
        