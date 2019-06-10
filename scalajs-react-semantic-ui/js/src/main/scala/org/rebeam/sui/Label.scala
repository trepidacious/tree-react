
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Label {
  
  sealed trait Attached{ val value: String }

  object Attached {
    case object TopLeft extends Attached { val value: String = "top left" }
    case object BottomLeft extends Attached { val value: String = "bottom left" }
    case object BottomRight extends Attached { val value: String = "bottom right" }
    case object Top extends Attached { val value: String = "top" }
    case object TopRight extends Attached { val value: String = "top right" }
    case object Bottom extends Attached { val value: String = "bottom" }
  }
            
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
            
  sealed trait Size{ val value: String }

  object Size {
    case object Mini extends Size { val value: String = "mini" }
    case object Tiny extends Size { val value: String = "tiny" }
    case object Massive extends Size { val value: String = "massive" }
    case object Small extends Size { val value: String = "small" }
    case object Medium extends Size { val value: String = "medium" }
    case object Big extends Size { val value: String = "big" }
    case object Huge extends Size { val value: String = "huge" }
    case object Large extends Size { val value: String = "large" }
  }
          
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[js.Any] = js.native
    var attached: js.UndefOr[String] = js.native
    var basic: js.UndefOr[Boolean] = js.native
    var circular: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var color: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var corner: js.UndefOr[js.Any] = js.native
    var detail: js.UndefOr[js.Any] = js.native
    var empty: js.UndefOr[js.Any] = js.native
    var floating: js.UndefOr[Boolean] = js.native
    var horizontal: js.UndefOr[Boolean] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var image: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var onRemove: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var pointing: js.UndefOr[js.Any] = js.native
    var removeIcon: js.UndefOr[js.Any] = js.native
    var ribbon: js.UndefOr[js.Any] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var tag: js.UndefOr[Boolean] = js.native
  }

  @JSImport("semantic-ui-react", "Label")
  @js.native
  object LabelJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](LabelJS)
  
  /**
   * A label displays content classification.
   * @param active
   *        A label can be active.
   * @param as
   *        An element type to render as (string or function).
   * @param attached
   *        A label can attach to a content segment.
   * @param basic
   *        A label can reduce its complexity.
   * @param children
   *        Primary content.
   * @param circular
   *        A label can be circular.
   * @param className
   *        Additional classes.
   * @param color
   *        Color of the label.
   * @param content
   *        Shorthand for primary content.
   * @param corner
   *        A label can position itself in the corner of an element.
   * @param detail
   *        Shorthand for LabelDetail.
   * @param empty
   *        Formats the label as a dot.
   * @param floating
   *        Float above another element in the upper right corner.
   * @param horizontal
   *        A horizontal label is formatted to label content along-side it horizontally.
   * @param icon
   *        Shorthand for Icon.
   * @param image
   *        A label can be formatted to emphasize an image or prop can be used as shorthand for Image.
   * @param key
   *        React key
   * @param onClick
   *        Called on click.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param onRemove
   *        Adds an "x" icon, called when "x" is clicked.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param pointing
   *        A label can point to content next to it.
   * @param removeIcon
   *        Shorthand for Icon to appear as the last child and trigger onRemove.
   * @param ribbon
   *        A label can appear as a ribbon attaching itself to an element.
   * @param size
   *        A label can have different sizes.
   * @param style
   *        React element CSS style
   * @param tag
   *        A label can appear as a tag.
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
    as: js.UndefOr[js.Any] = js.undefined,
    attached: js.UndefOr[Attached] = js.undefined,
    basic: js.UndefOr[Boolean] = js.undefined,
    circular: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    corner: js.UndefOr[js.Any] = js.undefined,
    detail: js.UndefOr[js.Any] = js.undefined,
    empty: js.UndefOr[js.Any] = js.undefined,
    floating: js.UndefOr[Boolean] = js.undefined,
    horizontal: js.UndefOr[Boolean] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    image: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    onRemove: js.UndefOr[Callback] = js.undefined,
    pointing: js.UndefOr[js.Any] = js.undefined,
    removeIcon: js.UndefOr[js.Any] = js.undefined,
    ribbon: js.UndefOr[js.Any] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    tag: js.UndefOr[Boolean] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (as.isDefined) {p.as = as}
    if (attached.isDefined) {p.attached = attached.map(v => v.value)}
    if (basic.isDefined) {p.basic = basic}
    if (circular.isDefined) {p.circular = circular}
    if (className.isDefined) {p.className = className}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (content.isDefined) {p.content = content}
    if (corner.isDefined) {p.corner = corner}
    if (detail.isDefined) {p.detail = detail}
    if (empty.isDefined) {p.empty = empty}
    if (floating.isDefined) {p.floating = floating}
    if (horizontal.isDefined) {p.horizontal = horizontal}
    if (icon.isDefined) {p.icon = icon}
    if (image.isDefined) {p.image = image}
    if (key.isDefined) {p.key = key}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (onRemove.isDefined) {p.onRemove = onRemove.map(v => v.toJsFn)}
    if (pointing.isDefined) {p.pointing = pointing}
    if (removeIcon.isDefined) {p.removeIcon = removeIcon}
    if (ribbon.isDefined) {p.ribbon = ribbon}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (tag.isDefined) {p.tag = tag}

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
        