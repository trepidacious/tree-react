
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object List {
  
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
    var animated: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[js.Any] = js.native
    var bulleted: js.UndefOr[Boolean] = js.native
    var celled: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var divided: js.UndefOr[Boolean] = js.native
    var floated: js.UndefOr[String] = js.native
    var horizontal: js.UndefOr[Boolean] = js.native
    var inverted: js.UndefOr[Boolean] = js.native
    var items: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var link: js.UndefOr[Boolean] = js.native
    var onItemClick: js.UndefOr[js.Any] = js.native
    var ordered: js.UndefOr[Boolean] = js.native
    var relaxed: js.UndefOr[js.Any] = js.native
    var selection: js.UndefOr[Boolean] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var verticalAlign: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "List")
  @js.native
  object ListJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](ListJS)
  
  /**
   * A list groups related content.
   * @param animated
   *        A list can animate to set the current item apart from the list.
   * @param as
   *        An element type to render as (string or function).
   * @param bulleted
   *        A list can mark items with a bullet.
   * @param celled
   *        A list can divide its items into cells.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param divided
   *        A list can show divisions between content.
   * @param floated
   *        An list can be floated left or right.
   * @param horizontal
   *        A list can be formatted to have items appear horizontally.
   * @param inverted
   *        A list can be inverted to appear on a dark background.
   * @param items
   *        Shorthand array of props for ListItem.
   * @param key
   *        React key
   * @param link
   *        A list can be specially formatted for navigation links.
   * @param onItemClick
   *        onClick handler for ListItem. Mutually exclusive with children.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All item props.
   * @param ordered
   *        A list can be ordered numerically.
   * @param relaxed
   *        A list can relax its padding to provide more negative space.
   * @param selection
   *        A selection list formats list items as possible choices.
   * @param size
   *        A list can vary in size.
   * @param style
   *        React element CSS style
   * @param verticalAlign
   *        An element inside a list can be vertically aligned.
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
    animated: js.UndefOr[Boolean] = js.undefined,
    as: js.UndefOr[js.Any] = js.undefined,
    bulleted: js.UndefOr[Boolean] = js.undefined,
    celled: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    divided: js.UndefOr[Boolean] = js.undefined,
    floated: js.UndefOr[Floated] = js.undefined,
    horizontal: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    items: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    link: js.UndefOr[Boolean] = js.undefined,
    onItemClick: js.UndefOr[js.Any] = js.undefined,
    ordered: js.UndefOr[Boolean] = js.undefined,
    relaxed: js.UndefOr[js.Any] = js.undefined,
    selection: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    verticalAlign: js.UndefOr[VerticalAlign] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (animated.isDefined) {p.animated = animated}
    if (as.isDefined) {p.as = as}
    if (bulleted.isDefined) {p.bulleted = bulleted}
    if (celled.isDefined) {p.celled = celled}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (divided.isDefined) {p.divided = divided}
    if (floated.isDefined) {p.floated = floated.map(v => v.value)}
    if (horizontal.isDefined) {p.horizontal = horizontal}
    if (inverted.isDefined) {p.inverted = inverted}
    if (items.isDefined) {p.items = items}
    if (key.isDefined) {p.key = key}
    if (link.isDefined) {p.link = link}
    if (onItemClick.isDefined) {p.onItemClick = onItemClick}
    if (ordered.isDefined) {p.ordered = ordered}
    if (relaxed.isDefined) {p.relaxed = relaxed}
    if (selection.isDefined) {p.selection = selection}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (verticalAlign.isDefined) {p.verticalAlign = verticalAlign.map(v => v.value)}

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
        