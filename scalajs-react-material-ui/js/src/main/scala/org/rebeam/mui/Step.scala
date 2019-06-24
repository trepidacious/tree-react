
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Step {
  
  sealed trait Orientation{ val value: String }

  object Orientation {
    case object Horizontal extends Orientation { val value: String = "horizontal" }
    case object Vertical extends Orientation { val value: String = "vertical" }
  }
          
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var alternativeLabel: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var completed: js.UndefOr[Boolean] = js.native
    var connector: js.UndefOr[japgolly.scalajs.react.raw.React.Element] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var index: js.UndefOr[Double] = js.native
    var key: js.UndefOr[String] = js.native
    var last: js.UndefOr[Boolean] = js.native
    var orientation: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/Step", JSImport.Default)
  @js.native
  object StepJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](StepJS)
  
  /**
   * 
   * @param active
   *        Sets the step as active. Is passed to child components.
   * @param alternativeLabel
   *        Property spread to root element
   *        Set internally by Stepper when it's supplied with the alternativeLabel property.
   * @param children
   *        Should be `Step` sub-components such as `StepLabel`, `StepContent`.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param completed
   *        Mark the step as completed. Is passed to child components.
   * @param connector
   *        Property spread to root element
   *        Passed down from Stepper if alternativeLabel is also set.
   * @param disabled
   *        Mark the step as disabled, will also disable the button if
   *        `StepButton` is a child of `Step`. Is passed to child components.
   * @param index
   *        Property spread to root element
   *        Used internally for numbering.
   * @param key
   *        React key
   * @param last
   *        Property spread to root element
   * @param orientation
   *        Property spread to root element
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
    alternativeLabel: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    completed: js.UndefOr[Boolean] = js.undefined,
    connector: js.UndefOr[VdomElement] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    index: js.UndefOr[Double] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    last: js.UndefOr[Boolean] = js.undefined,
    orientation: js.UndefOr[Orientation] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (alternativeLabel.isDefined) {p.alternativeLabel = alternativeLabel}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (completed.isDefined) {p.completed = completed}
    if (connector.isDefined) {p.connector = connector.map(v => v.rawElement)}
    if (disabled.isDefined) {p.disabled = disabled}
    if (index.isDefined) {p.index = index}
    if (key.isDefined) {p.key = key}
    if (last.isDefined) {p.last = last}
    if (orientation.isDefined) {p.orientation = orientation.map(v => v.value)}
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
        