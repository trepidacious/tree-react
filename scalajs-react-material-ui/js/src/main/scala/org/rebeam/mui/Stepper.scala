
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Stepper {
  
  sealed trait Orientation{ val value: String }

  object Orientation {
    case object Horizontal extends Orientation { val value: String = "horizontal" }
    case object Vertical extends Orientation { val value: String = "vertical" }
  }
          
  @js.native
  trait Props extends js.Object {
    var activeStep: js.UndefOr[Double] = js.native
    var alternativeLabel: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var connector: js.UndefOr[japgolly.scalajs.react.raw.React.Element] = js.native
    var elevation: js.UndefOr[Double] = js.native
    var key: js.UndefOr[String] = js.native
    var nonLinear: js.UndefOr[Boolean] = js.native
    var orientation: js.UndefOr[String] = js.native
    var square: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("@material-ui/core/Stepper", JSImport.Default)
  @js.native
  object StepperJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](StepperJS)
  
  /**
   * 
   * @param activeStep
   *        Set the active step (zero based index).
   * @param alternativeLabel
   *        If set to 'true' and orientation is horizontal,
   *        then the step label will be positioned under the icon.
   * @param children
   *        Two or more `&lt;Step /&gt;` components.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   *        Passed to Paper
   * @param connector
   *        A component to be placed between each step.
   * @param elevation
   *        Shadow depth, corresponds to `dp` in the spec.
   *        It's accepting values between 0 and 24 inclusive.
   *        Passed to Paper
   * @param key
   *        React key
   * @param nonLinear
   *        If set the `Stepper` will not assist in controlling steps for linear flow.
   * @param orientation
   *        The stepper orientation (layout flow direction).
   * @param square
   *        If `true`, rounded corners are disabled.
   *        Passed to Paper
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
    activeStep: js.UndefOr[Double] = js.undefined,
    alternativeLabel: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    connector: js.UndefOr[VdomElement] = js.undefined,
    elevation: js.UndefOr[Double] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    nonLinear: js.UndefOr[Boolean] = js.undefined,
    orientation: js.UndefOr[Orientation] = js.undefined,
    square: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (activeStep.isDefined) {p.activeStep = activeStep}
    if (alternativeLabel.isDefined) {p.alternativeLabel = alternativeLabel}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (connector.isDefined) {p.connector = connector.map(v => v.rawElement)}
    if (elevation.isDefined) {p.elevation = elevation}
    if (key.isDefined) {p.key = key}
    if (nonLinear.isDefined) {p.nonLinear = nonLinear}
    if (orientation.isDefined) {p.orientation = orientation.map(v => v.value)}
    if (square.isDefined) {p.square = square}
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
        