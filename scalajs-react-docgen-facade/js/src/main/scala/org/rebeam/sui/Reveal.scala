
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Reveal {
  
  sealed trait Animated{ val value: String }

  object Animated {
    case object MoveRight extends Animated { val value: String = "move right" }
    case object SmallFade extends Animated { val value: String = "small fade" }
    case object RotateLeft extends Animated { val value: String = "rotate left" }
    case object MoveDown extends Animated { val value: String = "move down" }
    case object MoveUp extends Animated { val value: String = "move up" }
    case object Move extends Animated { val value: String = "move" }
    case object Rotate extends Animated { val value: String = "rotate" }
    case object Fade extends Animated { val value: String = "fade" }
  }
          
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var animated: js.UndefOr[String] = js.native
    var as: js.UndefOr[js.Any] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var instant: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "Reveal")
  @js.native
  object RevealJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](RevealJS)
  
  /**
   * A reveal displays additional content in place of previous content when activated.
   * @param active
   *        An active reveal displays its hidden content.
   * @param animated
   *        An animation name that will be applied to Reveal.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param disabled
   *        A disabled reveal will not animate when hovered.
   * @param instant
   *        An element can show its content without delay.
   * @param key
   *        React key
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
    animated: js.UndefOr[Animated] = js.undefined,
    as: js.UndefOr[js.Any] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    instant: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (animated.isDefined) {p.animated = animated.map(v => v.value)}
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (disabled.isDefined) {p.disabled = disabled}
    if (instant.isDefined) {p.instant = instant}
    if (key.isDefined) {p.key = key}
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
        