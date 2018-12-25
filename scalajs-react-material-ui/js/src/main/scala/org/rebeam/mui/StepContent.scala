
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object StepContent {
  
  sealed trait Orientation{ val value: String }

  object Orientation {
    case object Horizontal extends Orientation { val value: String = "horizontal" }
    case object Vertical extends Orientation { val value: String = "vertical" }
  }
          
  @js.native
  trait Props extends js.Object {
    var TransitionComponent: js.UndefOr[js.Any] = js.native
    var TransitionProps: js.UndefOr[js.Object] = js.native
    var active: js.UndefOr[Boolean] = js.native
    var alternativeLabel: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var completed: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var last: js.UndefOr[Boolean] = js.native
    var optional: js.UndefOr[Boolean] = js.native
    var orientation: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var transitionDuration: js.UndefOr[js.Any] = js.native
  }

  @JSImport("@material-ui/core/StepContent", JSImport.Default)
  @js.native
  object StepContentJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](StepContentJS)
  
  /**
   * 
   * @param TransitionComponent
   *        The component used for the transition.
   * @param TransitionProps
   *        Properties applied to the `Transition` element.
   * @param active
   *        Property spread to root element
   *        Expands the content.
   * @param alternativeLabel
   *        Property spread to root element
   *        Set internally by Step when it's supplied with the alternativeLabel property.
   * @param children
   *        Step content.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param completed
   *        Property spread to root element
   * @param key
   *        React key
   * @param last
   *        Property spread to root element
   * @param optional
   *        Property spread to root element
   *        Set internally by Step when it's supplied with the optional property.
   * @param orientation
   *        Property spread to root element
   * @param style
   *        React element CSS style
   * @param transitionDuration
   *        Adjust the duration of the content expand transition.
   *        Passed as a property to the transition component.
   *        
   *        Set to 'auto' to automatically calculate transition time based on height.
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
    TransitionComponent: js.UndefOr[js.Any] = js.undefined,
    TransitionProps: js.UndefOr[js.Object] = js.undefined,
    active: js.UndefOr[Boolean] = js.undefined,
    alternativeLabel: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    completed: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    last: js.UndefOr[Boolean] = js.undefined,
    optional: js.UndefOr[Boolean] = js.undefined,
    orientation: js.UndefOr[Orientation] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    transitionDuration: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (TransitionComponent.isDefined) {p.TransitionComponent = TransitionComponent}
    if (TransitionProps.isDefined) {p.TransitionProps = TransitionProps}
    if (active.isDefined) {p.active = active}
    if (alternativeLabel.isDefined) {p.alternativeLabel = alternativeLabel}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (completed.isDefined) {p.completed = completed}
    if (key.isDefined) {p.key = key}
    if (last.isDefined) {p.last = last}
    if (optional.isDefined) {p.optional = optional}
    if (orientation.isDefined) {p.orientation = orientation.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (transitionDuration.isDefined) {p.transitionDuration = transitionDuration}

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
        