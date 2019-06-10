
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Visibility {
  
  sealed trait UpdateOn{ val value: String }

  object UpdateOn {
    case object Events extends UpdateOn { val value: String = "events" }
    case object Repaint extends UpdateOn { val value: String = "repaint" }
  }
          
  @js.native
  trait Props extends js.Object {
    var as: js.UndefOr[js.Any] = js.native
    var context: js.UndefOr[js.Object] = js.native
    var continuous: js.UndefOr[Boolean] = js.native
    var fireOnMount: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var offset: js.UndefOr[js.Any] = js.native
    var onBottomPassed: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onBottomPassedReverse: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onBottomVisible: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onBottomVisibleReverse: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onOffScreen: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onOnScreen: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onPassed: js.UndefOr[js.Object] = js.native
    var onPassing: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onPassingReverse: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onTopPassed: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onTopPassedReverse: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onTopVisible: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onTopVisibleReverse: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onUpdate: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var once: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var updateOn: js.UndefOr[String] = js.native
  }

  @JSImport("semantic-ui-react", "Visibility")
  @js.native
  object VisibilityJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](VisibilityJS)
  
  /**
   * Visibility provides a set of callbacks for when a content appears in the viewport.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param context
   *        Context which visibility should attach onscroll events.
   * @param continuous
   *        When set to true a callback will occur anytime an element passes a condition not just immediately after the
   *        threshold is met.
   * @param fireOnMount
   *        Fires callbacks immediately after mount.
   * @param key
   *        React key
   * @param offset
   *        Value that context should be adjusted in pixels. Useful for making content appear below content fixed to the
   *        page.
   * @param onBottomPassed
   *        Element's bottom edge has passed top of screen.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onBottomPassedReverse
   *        Element's bottom edge has not passed top of screen.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onBottomVisible
   *        Element's bottom edge has passed bottom of screen
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onBottomVisibleReverse
   *        Element's bottom edge has not passed bottom of screen.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onOffScreen
   *        Element is not visible on the screen.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onOnScreen
   *        Element is visible on the screen.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onPassed
   *        Element is not visible on the screen.
   * @param onPassing
   *        Any part of an element is visible on screen.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onPassingReverse
   *        Element's top has not passed top of screen but bottom has.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onTopPassed
   *        Element's top edge has passed top of the screen.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onTopPassedReverse
   *        Element's top edge has not passed top of the screen.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onTopVisible
   *        Element's top edge has passed bottom of screen.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onTopVisibleReverse
   *        Element's top edge has not passed bottom of screen.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param onUpdate
   *        Element's top edge has passed bottom of screen.
   *        
   *        parameter {null}
   *        parameter {object} data - All props.
   * @param once
   *        When set to false a callback will occur each time an element passes the threshold for a condition.
   * @param style
   *        React element CSS style
   * @param updateOn
   *        Allows to choose the mode of the position calculations:
   *        - `events` - (default) update and fire callbacks only on scroll/resize events
   *        - `repaint` - update and fire callbacks on browser repaint (animation frames)
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
    context: js.UndefOr[js.Object] = js.undefined,
    continuous: js.UndefOr[Boolean] = js.undefined,
    fireOnMount: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    offset: js.UndefOr[js.Any] = js.undefined,
    onBottomPassed: js.UndefOr[Callback] = js.undefined,
    onBottomPassedReverse: js.UndefOr[Callback] = js.undefined,
    onBottomVisible: js.UndefOr[Callback] = js.undefined,
    onBottomVisibleReverse: js.UndefOr[Callback] = js.undefined,
    onOffScreen: js.UndefOr[Callback] = js.undefined,
    onOnScreen: js.UndefOr[Callback] = js.undefined,
    onPassed: js.UndefOr[js.Object] = js.undefined,
    onPassing: js.UndefOr[Callback] = js.undefined,
    onPassingReverse: js.UndefOr[Callback] = js.undefined,
    onTopPassed: js.UndefOr[Callback] = js.undefined,
    onTopPassedReverse: js.UndefOr[Callback] = js.undefined,
    onTopVisible: js.UndefOr[Callback] = js.undefined,
    onTopVisibleReverse: js.UndefOr[Callback] = js.undefined,
    onUpdate: js.UndefOr[Callback] = js.undefined,
    once: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    updateOn: js.UndefOr[UpdateOn] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (as.isDefined) {p.as = as}
    if (context.isDefined) {p.context = context}
    if (continuous.isDefined) {p.continuous = continuous}
    if (fireOnMount.isDefined) {p.fireOnMount = fireOnMount}
    if (key.isDefined) {p.key = key}
    if (offset.isDefined) {p.offset = offset}
    if (onBottomPassed.isDefined) {p.onBottomPassed = onBottomPassed.map(v => v.toJsFn)}
    if (onBottomPassedReverse.isDefined) {p.onBottomPassedReverse = onBottomPassedReverse.map(v => v.toJsFn)}
    if (onBottomVisible.isDefined) {p.onBottomVisible = onBottomVisible.map(v => v.toJsFn)}
    if (onBottomVisibleReverse.isDefined) {p.onBottomVisibleReverse = onBottomVisibleReverse.map(v => v.toJsFn)}
    if (onOffScreen.isDefined) {p.onOffScreen = onOffScreen.map(v => v.toJsFn)}
    if (onOnScreen.isDefined) {p.onOnScreen = onOnScreen.map(v => v.toJsFn)}
    if (onPassed.isDefined) {p.onPassed = onPassed}
    if (onPassing.isDefined) {p.onPassing = onPassing.map(v => v.toJsFn)}
    if (onPassingReverse.isDefined) {p.onPassingReverse = onPassingReverse.map(v => v.toJsFn)}
    if (onTopPassed.isDefined) {p.onTopPassed = onTopPassed.map(v => v.toJsFn)}
    if (onTopPassedReverse.isDefined) {p.onTopPassedReverse = onTopPassedReverse.map(v => v.toJsFn)}
    if (onTopVisible.isDefined) {p.onTopVisible = onTopVisible.map(v => v.toJsFn)}
    if (onTopVisibleReverse.isDefined) {p.onTopVisibleReverse = onTopVisibleReverse.map(v => v.toJsFn)}
    if (onUpdate.isDefined) {p.onUpdate = onUpdate.map(v => v.toJsFn)}
    if (once.isDefined) {p.once = once}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (updateOn.isDefined) {p.updateOn = updateOn.map(v => v.value)}

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
        