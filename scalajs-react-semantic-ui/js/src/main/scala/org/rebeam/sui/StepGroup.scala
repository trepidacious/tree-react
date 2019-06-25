
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object StepGroup {
  
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
            
  sealed trait Stackable{ val value: String }

  object Stackable {
    case object Tablet extends Stackable { val value: String = "tablet" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var attached: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var fluid: js.UndefOr[Boolean] = js.native
    var items: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var ordered: js.UndefOr[Boolean] = js.native
    var size: js.UndefOr[String] = js.native
    var stackable: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var unstackable: js.UndefOr[Boolean] = js.native
    var vertical: js.UndefOr[Boolean] = js.native
    var widths: js.UndefOr[js.Any] = js.native
  }

  @JSImport("semantic-ui-react", "StepGroup")
  @js.native
  object StepGroupJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](StepGroupJS)
  
  /**
   * A set of steps.
   * @param as
   *        An element type to render as (string or function).
   * @param attached
   *        Steps can be attached to other elements.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param fluid
   *        A fluid step takes up the width of its container.
   * @param items
   *        Shorthand array of props for Step.
   * @param key
   *        React key
   * @param ordered
   *        A step can show a ordered sequence of steps.
   * @param size
   *        Steps can have different sizes.
   * @param stackable
   *        A step can stack vertically only on smaller screens.
   * @param style
   *        React element CSS style
   * @param unstackable
   *        A step can prevent itself from stacking on mobile.
   * @param vertical
   *        A step can be displayed stacked vertically.
   * @param widths
   *        Steps can be divided evenly inside their parent.
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
    attached: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    items: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    ordered: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    stackable: js.UndefOr[Stackable] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    unstackable: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined,
    widths: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (attached.isDefined) {p.attached = attached}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (fluid.isDefined) {p.fluid = fluid}
    if (items.isDefined) {p.items = items}
    if (key.isDefined) {p.key = key}
    if (ordered.isDefined) {p.ordered = ordered}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (stackable.isDefined) {p.stackable = stackable.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (unstackable.isDefined) {p.unstackable = unstackable}
    if (vertical.isDefined) {p.vertical = vertical}
    if (widths.isDefined) {p.widths = widths}

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
        