
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object MobileStepper {
  
  sealed trait Position{ val value: String }

  object Position {
    case object Bottom extends Position { val value: String = "bottom" }
    case object Top extends Position { val value: String = "top" }
    case object Static extends Position { val value: String = "static" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Text extends Variant { val value: String = "text" }
    case object Dots extends Variant { val value: String = "dots" }
    case object Progress extends Variant { val value: String = "progress" }
  }
          
  @js.native
  trait Props extends js.Object {
    var LinearProgressProps: js.UndefOr[js.Object] = js.native
    var activeStep: js.UndefOr[Double] = js.native
    var backButton: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var elevation: js.UndefOr[Double] = js.native
    var key: js.UndefOr[String] = js.native
    var nextButton: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var position: js.UndefOr[String] = js.native
    var square: js.UndefOr[Boolean] = js.native
    var steps: Double = js.native
    var style: js.UndefOr[js.Object] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/MobileStepper", JSImport.Default)
  @js.native
  object MobileStepperJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](MobileStepperJS)
  
  /**
   * 
   * @param LinearProgressProps
   *        Properties applied to the `LinearProgress` element.
   * @param activeStep
   *        Set the active step (zero based index).
   *        Defines which dot is highlighted when the variant is 'dots'.
   * @param backButton
   *        A back button element. For instance, it can be be a `Button` or a `IconButton`.
   * @param children
   *        The content of the component.
   *        Passed to Paper
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   *        Passed to Paper
   * @param elevation
   *        Shadow depth, corresponds to `dp` in the spec.
   *        It's accepting values between 0 and 24 inclusive.
   *        Passed to Paper
   * @param key
   *        React key
   * @param nextButton
   *        A next button element. For instance, it can be be a `Button` or a `IconButton`.
   * @param position
   *        Set the positioning type.
   * @param square
   *        If `true`, rounded corners are disabled.
   *        Passed to Paper
   * @param steps
   *        The total steps.
   * @param style
   *        React element CSS style
   * @param variant
   *        The variant to use.
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
    LinearProgressProps: js.UndefOr[js.Object] = js.undefined,
    activeStep: js.UndefOr[Double] = js.undefined,
    backButton: js.UndefOr[VdomNode] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    elevation: js.UndefOr[Double] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    nextButton: js.UndefOr[VdomNode] = js.undefined,
    position: js.UndefOr[Position] = js.undefined,
    square: js.UndefOr[Boolean] = js.undefined,
    steps: Double,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (LinearProgressProps.isDefined) {p.LinearProgressProps = LinearProgressProps}
    if (activeStep.isDefined) {p.activeStep = activeStep}
    if (backButton.isDefined) {p.backButton = backButton.map(v => v.rawNode)}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (component.isDefined) {p.component = component}
    if (elevation.isDefined) {p.elevation = elevation}
    if (key.isDefined) {p.key = key}
    if (nextButton.isDefined) {p.nextButton = nextButton.map(v => v.rawNode)}
    if (position.isDefined) {p.position = position.map(v => v.value)}
    if (square.isDefined) {p.square = square}
    p.steps = steps
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (variant.isDefined) {p.variant = variant.map(v => v.value)}

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
        