
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Header {
  
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
    case object Tiny extends Size { val value: String = "tiny" }
    case object Small extends Size { val value: String = "small" }
    case object Medium extends Size { val value: String = "medium" }
    case object Huge extends Size { val value: String = "huge" }
    case object Large extends Size { val value: String = "large" }
  }
            
  sealed trait TextAlign{ val value: String }

  object TextAlign {
    case object Left extends TextAlign { val value: String = "left" }
    case object Center extends TextAlign { val value: String = "center" }
    case object Right extends TextAlign { val value: String = "right" }
    case object Justified extends TextAlign { val value: String = "justified" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[String] = js.native
    var attached: js.UndefOr[js.Any] = js.native
    var block: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var color: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var dividing: js.UndefOr[Boolean] = js.native
    var floated: js.UndefOr[String] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var image: js.UndefOr[js.Any] = js.native
    var inverted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var sub: js.UndefOr[Boolean] = js.native
    var subheader: js.UndefOr[js.Any] = js.native
    var textAlign: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "Header")
  @js.native
  object HeaderJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](HeaderJS)
  
  /**
   * A header provides a short summary of content
   * @param as
   *        An element type to render as (string or function).
   * @param attached
   *        Attach header  to other content, like a segment.
   * @param block
   *        Format header to appear inside a content block.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param color
   *        Color of the header.
   * @param content
   *        Shorthand for primary content.
   * @param disabled
   *        Show that the header is inactive.
   * @param dividing
   *        Divide header from the content below it.
   * @param floated
   *        Header can sit to the left or right of other content.
   * @param icon
   *        Add an icon by icon name or pass an Icon.
   * @param image
   *        Add an image by img src or pass an Image.
   * @param inverted
   *        Inverts the color of the header for dark backgrounds.
   * @param key
   *        React key
   * @param size
   *        Content headings are sized with em and are based on the font-size of their container.
   * @param style
   *        React element CSS style
   * @param sub
   *        Headers may be formatted to label smaller or de-emphasized content.
   * @param subheader
   *        Shorthand for Header.Subheader.
   * @param textAlign
   *        Align header content.
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
    block: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    dividing: js.UndefOr[Boolean] = js.undefined,
    floated: js.UndefOr[Floated] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    image: js.UndefOr[js.Any] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    sub: js.UndefOr[Boolean] = js.undefined,
    subheader: js.UndefOr[js.Any] = js.undefined,
    textAlign: js.UndefOr[TextAlign] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (attached.isDefined) {p.attached = attached}
    if (block.isDefined) {p.block = block}
    if (className.isDefined) {p.className = className}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (content.isDefined) {p.content = content}
    if (disabled.isDefined) {p.disabled = disabled}
    if (dividing.isDefined) {p.dividing = dividing}
    if (floated.isDefined) {p.floated = floated.map(v => v.value)}
    if (icon.isDefined) {p.icon = icon}
    if (image.isDefined) {p.image = image}
    if (inverted.isDefined) {p.inverted = inverted}
    if (key.isDefined) {p.key = key}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (sub.isDefined) {p.sub = sub}
    if (subheader.isDefined) {p.subheader = subheader}
    if (textAlign.isDefined) {p.textAlign = textAlign.map(v => v.value)}

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
        