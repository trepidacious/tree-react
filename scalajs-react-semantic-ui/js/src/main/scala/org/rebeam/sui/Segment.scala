
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Segment {
  
  sealed trait Color{ val value: String }

  object Color {
    case object Grey extends Color { val value: String = "grey" }
    case object Teal extends Color { val value: String = "teal" }
    case object Black extends Color { val value: String = "black" }
    case object Purple extends Color { val value: String = "purple" }
    case object Violet extends Color { val value: String = "violet" }
    case object Green extends Color { val value: String = "green" }
    case object Orange extends Color { val value: String = "orange" }
    case object Yellow extends Color { val value: String = "yellow" }
    case object Olive extends Color { val value: String = "olive" }
    case object Red extends Color { val value: String = "red" }
    case object Brown extends Color { val value: String = "brown" }
    case object Blue extends Color { val value: String = "blue" }
    case object Pink extends Color { val value: String = "pink" }
  }
            
  sealed trait Floated{ val value: String }

  object Floated {
    case object Left extends Floated { val value: String = "left" }
    case object Right extends Floated { val value: String = "right" }
  }
            
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
            
  sealed trait TextAlign{ val value: String }

  object TextAlign {
    case object Left extends TextAlign { val value: String = "left" }
    case object Center extends TextAlign { val value: String = "center" }
    case object Right extends TextAlign { val value: String = "right" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[js.Any] = js.native
    var attached: js.UndefOr[js.Any] = js.native
    var basic: js.UndefOr[Boolean] = js.native
    var circular: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var clearing: js.UndefOr[Boolean] = js.native
    var color: js.UndefOr[String] = js.native
    var compact: js.UndefOr[Boolean] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var floated: js.UndefOr[String] = js.native
    var inverted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var loading: js.UndefOr[Boolean] = js.native
    var padded: js.UndefOr[js.Any] = js.native
    var piled: js.UndefOr[Boolean] = js.native
    var placeholder: js.UndefOr[Boolean] = js.native
    var raised: js.UndefOr[Boolean] = js.native
    var secondary: js.UndefOr[Boolean] = js.native
    var size: js.UndefOr[String] = js.native
    var stacked: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var tertiary: js.UndefOr[Boolean] = js.native
    var textAlign: js.UndefOr[String] = js.native
    var vertical: js.UndefOr[Boolean] = js.native
  }

  @JSImport("semantic-ui-react", "Segment")
  @js.native
  object SegmentJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](SegmentJS)
  
  /**
   * A segment is used to create a grouping of related content.
   * @param as
   *        An element type to render as (string or function).
   * @param attached
   *        Attach segment to other content, like a header.
   * @param basic
   *        A basic segment has no special formatting.
   * @param children
   *        Primary content.
   * @param circular
   *        A segment can be circular.
   * @param className
   *        Additional classes.
   * @param clearing
   *        A segment can clear floated content.
   * @param color
   *        Segment can be colored.
   * @param compact
   *        A segment may take up only as much space as is necessary.
   * @param content
   *        Shorthand for primary content.
   * @param disabled
   *        A segment may show its content is disabled.
   * @param floated
   *        Segment content can be floated to the left or right.
   * @param inverted
   *        A segment can have its colors inverted for contrast.
   * @param key
   *        React key
   * @param loading
   *        A segment may show its content is being loaded.
   * @param padded
   *        A segment can increase its padding.
   * @param piled
   *        Formatted to look like a pile of pages.
   * @param placeholder
   *        A segment can be used to reserve space for conditionally displayed content.
   * @param raised
   *        A segment may be formatted to raise above the page.
   * @param secondary
   *        A segment can be formatted to appear less noticeable.
   * @param size
   *        A segment can have different sizes.
   * @param stacked
   *        Formatted to show it contains multiple pages.
   * @param style
   *        React element CSS style
   * @param tertiary
   *        A segment can be formatted to appear even less noticeable.
   * @param textAlign
   *        Formats content to be aligned as part of a vertical group.
   * @param vertical
   *        Formats content to be aligned vertically.
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
    attached: js.UndefOr[js.Any] = js.undefined,
    basic: js.UndefOr[Boolean] = js.undefined,
    circular: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    clearing: js.UndefOr[Boolean] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    compact: js.UndefOr[Boolean] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    floated: js.UndefOr[Floated] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    loading: js.UndefOr[Boolean] = js.undefined,
    padded: js.UndefOr[js.Any] = js.undefined,
    piled: js.UndefOr[Boolean] = js.undefined,
    placeholder: js.UndefOr[Boolean] = js.undefined,
    raised: js.UndefOr[Boolean] = js.undefined,
    secondary: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    stacked: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    tertiary: js.UndefOr[Boolean] = js.undefined,
    textAlign: js.UndefOr[TextAlign] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (attached.isDefined) {p.attached = attached}
    if (basic.isDefined) {p.basic = basic}
    if (circular.isDefined) {p.circular = circular}
    if (className.isDefined) {p.className = className}
    if (clearing.isDefined) {p.clearing = clearing}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (compact.isDefined) {p.compact = compact}
    if (content.isDefined) {p.content = content}
    if (disabled.isDefined) {p.disabled = disabled}
    if (floated.isDefined) {p.floated = floated.map(v => v.value)}
    if (inverted.isDefined) {p.inverted = inverted}
    if (key.isDefined) {p.key = key}
    if (loading.isDefined) {p.loading = loading}
    if (padded.isDefined) {p.padded = padded}
    if (piled.isDefined) {p.piled = piled}
    if (placeholder.isDefined) {p.placeholder = placeholder}
    if (raised.isDefined) {p.raised = raised}
    if (secondary.isDefined) {p.secondary = secondary}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (stacked.isDefined) {p.stacked = stacked}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (tertiary.isDefined) {p.tertiary = tertiary}
    if (textAlign.isDefined) {p.textAlign = textAlign.map(v => v.value)}
    if (vertical.isDefined) {p.vertical = vertical}

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
        