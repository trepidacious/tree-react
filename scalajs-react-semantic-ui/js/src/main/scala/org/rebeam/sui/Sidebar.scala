
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Sidebar {
  
  sealed trait Animation{ val value: String }

  object Animation {
    case object Push extends Animation { val value: String = "push" }
    case object Overlay extends Animation { val value: String = "overlay" }
    case object SlideAlong extends Animation { val value: String = "slide along" }
    case object SlideOut extends Animation { val value: String = "slide out" }
    case object ScaleDown extends Animation { val value: String = "scale down" }
    case object Uncover extends Animation { val value: String = "uncover" }
  }
            
  sealed trait Direction{ val value: String }

  object Direction {
    case object Top extends Direction { val value: String = "top" }
    case object Right extends Direction { val value: String = "right" }
    case object Bottom extends Direction { val value: String = "bottom" }
    case object Left extends Direction { val value: String = "left" }
  }
            
  sealed trait Width{ val value: String }

  object Width {
    case object VeryThin extends Width { val value: String = "very thin" }
    case object Thin extends Width { val value: String = "thin" }
    case object Wide extends Width { val value: String = "wide" }
    case object VeryWide extends Width { val value: String = "very wide" }
  }
          
  @js.native
  trait Props extends js.Object {
    var animation: js.UndefOr[String] = js.native
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var direction: js.UndefOr[String] = js.native
    var key: js.UndefOr[String] = js.native
    var onHidden: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onHide: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onShow: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onVisible: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var target: js.UndefOr[js.Any] = js.native
    var visible: js.UndefOr[Boolean] = js.native
    var width: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "Sidebar")
  @js.native
  object SidebarJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](SidebarJS)
  
  /**
   * A sidebar hides additional content beside a page.
   * @param animation
   *        Animation style.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param content
   *        Shorthand for primary content.
   * @param direction
   *        Direction the sidebar should appear on.
   * @param key
   *        React key
   * @param onHidden
   *        Called after a sidebar has finished animating out.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onHide
   *        Called before a sidebar begins to animate out.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param onShow
   *        Called when a sidebar has finished animating in.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onVisible
   *        Called when a sidebar begins animating in.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param style
   *        React element CSS style
   * @param target
   *        A sidebar can handle clicks on the passed element.
   * @param visible
   *        Controls whether or not the sidebar is visible on the page.
   * @param width
   *        Sidebar width.
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
    animation: js.UndefOr[Animation] = js.undefined,
    as: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    direction: js.UndefOr[Direction] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onHidden: js.UndefOr[Callback] = js.undefined,
    onHide: js.UndefOr[Callback] = js.undefined,
    onShow: js.UndefOr[Callback] = js.undefined,
    onVisible: js.UndefOr[Callback] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    target: js.UndefOr[js.Any] = js.undefined,
    visible: js.UndefOr[Boolean] = js.undefined,
    width: js.UndefOr[Width] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (animation.isDefined) {p.animation = animation.map(v => v.value)}
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (content.isDefined) {p.content = content}
    if (direction.isDefined) {p.direction = direction.map(v => v.value)}
    if (key.isDefined) {p.key = key}
    if (onHidden.isDefined) {p.onHidden = onHidden.map(v => v.toJsFn)}
    if (onHide.isDefined) {p.onHide = onHide.map(v => v.toJsFn)}
    if (onShow.isDefined) {p.onShow = onShow.map(v => v.toJsFn)}
    if (onVisible.isDefined) {p.onVisible = onVisible.map(v => v.toJsFn)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (target.isDefined) {p.target = target}
    if (visible.isDefined) {p.visible = visible}
    if (width.isDefined) {p.width = width.map(v => v.value)}

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
        