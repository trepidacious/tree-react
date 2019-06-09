
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Image {
  
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
    case object Medium extends Size { val value: String = "medium" }
    case object Big extends Size { val value: String = "big" }
    case object Huge extends Size { val value: String = "huge" }
    case object Large extends Size { val value: String = "large" }
  }
            
  sealed trait VerticalAlign{ val value: String }

  object VerticalAlign {
    case object Bottom extends VerticalAlign { val value: String = "bottom" }
    case object Middle extends VerticalAlign { val value: String = "middle" }
    case object Top extends VerticalAlign { val value: String = "top" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[js.Any] = js.native
    var avatar: js.UndefOr[Boolean] = js.native
    var bordered: js.UndefOr[Boolean] = js.native
    var centered: js.UndefOr[Boolean] = js.native
    var circular: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var dimmer: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var floated: js.UndefOr[String] = js.native
    var fluid: js.UndefOr[js.Any] = js.native
    var hidden: js.UndefOr[Boolean] = js.native
    var href: js.UndefOr[String] = js.native
    var inline: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var label: js.UndefOr[js.Any] = js.native
    var rounded: js.UndefOr[Boolean] = js.native
    var size: js.UndefOr[String] = js.native
    var spaced: js.UndefOr[js.Any] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var ui: js.UndefOr[Boolean] = js.native
    var verticalAlign: js.UndefOr[String] = js.native
    var wrapped: js.UndefOr[Boolean] = js.native
  }

  @JSImport("semantic-ui-react", "Image")
  @js.native
  object ImageJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](ImageJS)
  
  /**
   * An image is a graphic representation of something.
   * @see Icon
   * @param as
   *        An element type to render as (string or function).
   * @param avatar
   *        An image may be formatted to appear inline with text as an avatar.
   * @param bordered
   *        An image may include a border to emphasize the edges of white or transparent content.
   * @param centered
   *        An image can appear centered in a content block.
   * @param children
   *        Primary content.
   * @param circular
   *        An image may appear circular.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param dimmer
   *        Shorthand for Dimmer.
   * @param disabled
   *        An image can show that it is disabled and cannot be selected.
   * @param floated
   *        An image can sit to the left or right of other content.
   * @param fluid
   *        An image can take up the width of its container.
   * @param hidden
   *        An image can be hidden.
   * @param href
   *        Renders the Image as an &lt;a&gt; tag with this href.
   * @param inline
   *        An image may appear inline.
   * @param key
   *        React key
   * @param label
   *        Shorthand for Label.
   * @param rounded
   *        An image may appear rounded.
   * @param size
   *        An image may appear at different sizes.
   * @param spaced
   *        An image can specify that it needs an additional spacing to separate it from nearby content.
   * @param style
   *        React element CSS style
   * @param ui
   *        Whether or not to add the ui className.
   * @param verticalAlign
   *        An image can specify its vertical alignment.
   * @param wrapped
   *        An image can render wrapped in a `div.ui.image` as alternative HTML markup.
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
    avatar: js.UndefOr[Boolean] = js.undefined,
    bordered: js.UndefOr[Boolean] = js.undefined,
    centered: js.UndefOr[Boolean] = js.undefined,
    circular: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    dimmer: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    floated: js.UndefOr[Floated] = js.undefined,
    fluid: js.UndefOr[js.Any] = js.undefined,
    hidden: js.UndefOr[Boolean] = js.undefined,
    href: js.UndefOr[String] = js.undefined,
    inline: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[js.Any] = js.undefined,
    rounded: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    spaced: js.UndefOr[js.Any] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    ui: js.UndefOr[Boolean] = js.undefined,
    verticalAlign: js.UndefOr[VerticalAlign] = js.undefined,
    wrapped: js.UndefOr[Boolean] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (avatar.isDefined) {p.avatar = avatar}
    if (bordered.isDefined) {p.bordered = bordered}
    if (centered.isDefined) {p.centered = centered}
    if (circular.isDefined) {p.circular = circular}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (dimmer.isDefined) {p.dimmer = dimmer}
    if (disabled.isDefined) {p.disabled = disabled}
    if (floated.isDefined) {p.floated = floated.map(v => v.value)}
    if (fluid.isDefined) {p.fluid = fluid}
    if (hidden.isDefined) {p.hidden = hidden}
    if (href.isDefined) {p.href = href}
    if (inline.isDefined) {p.inline = inline}
    if (key.isDefined) {p.key = key}
    if (label.isDefined) {p.label = label}
    if (rounded.isDefined) {p.rounded = rounded}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (spaced.isDefined) {p.spaced = spaced}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (ui.isDefined) {p.ui = ui}
    if (verticalAlign.isDefined) {p.verticalAlign = verticalAlign.map(v => v.value)}
    if (wrapped.isDefined) {p.wrapped = wrapped}

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
        