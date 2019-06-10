
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Progress {
  
  sealed trait Attached{ val value: String }

  object Attached {
    case object Top extends Attached { val value: String = "top" }
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
    case object Tiny extends Size { val value: String = "tiny" }
    case object Small extends Size { val value: String = "small" }
    case object Medium extends Size { val value: String = "medium" }
    case object Big extends Size { val value: String = "big" }
    case object Large extends Size { val value: String = "large" }
  }
          
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[js.Any] = js.native
    var attached: js.UndefOr[String] = js.native
    var autoSuccess: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var color: js.UndefOr[String] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var error: js.UndefOr[Boolean] = js.native
    var indicating: js.UndefOr[Boolean] = js.native
    var inverted: js.UndefOr[Boolean] = js.native
    var key: js.UndefOr[String] = js.native
    var label: js.UndefOr[js.Any] = js.native
    var percent: js.UndefOr[js.Any] = js.native
    var precision: js.UndefOr[Double] = js.native
    var progress: js.UndefOr[js.Any] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var success: js.UndefOr[Boolean] = js.native
    var total: js.UndefOr[js.Any] = js.native
    var value: js.UndefOr[js.Any] = js.native
    var warning: js.UndefOr[Boolean] = js.native
  }

  @JSImport("semantic-ui-react", "Progress")
  @js.native
  object ProgressJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](ProgressJS)
  
  /**
   * A progress bar shows the progression of a task.
   * @param active
   *        A progress bar can show activity.
   * @param as
   *        An element type to render as (string or function).
   * @param attached
   *        A progress bar can attach to and show the progress of an element (i.e. Card or Segment).
   * @param autoSuccess
   *        Whether success state should automatically trigger when progress completes.
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param color
   *        A progress bar can have different colors.
   * @param content
   *        Shorthand for primary content.
   * @param disabled
   *        A progress bar be disabled.
   * @param error
   *        A progress bar can show a error state.
   * @param indicating
   *        An indicating progress bar visually indicates the current level of progress of a task.
   * @param inverted
   *        A progress bar can have its colors inverted.
   * @param key
   *        React key
   * @param label
   *        Can be set to either to display progress as percent or ratio.
   * @param percent
   *        Current percent complete.
   * @param precision
   *        Decimal point precision for calculated progress.
   * @param progress
   *        A progress bar can contain a text value indicating current progress.
   * @param size
   *        A progress bar can vary in size.
   * @param style
   *        React element CSS style
   * @param success
   *        A progress bar can show a success state.
   * @param total
   *        For use with value. Together, these will calculate the percent. Mutually excludes percent.
   * @param value
   *        For use with total. Together, these will calculate the percent. Mutually excludes percent.
   * @param warning
   *        A progress bar can show a warning state.
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
    autoSuccess: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    color: js.UndefOr[Color] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    indicating: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    label: js.UndefOr[js.Any] = js.undefined,
    percent: js.UndefOr[js.Any] = js.undefined,
    precision: js.UndefOr[Double] = js.undefined,
    progress: js.UndefOr[js.Any] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    success: js.UndefOr[Boolean] = js.undefined,
    total: js.UndefOr[js.Any] = js.undefined,
    value: js.UndefOr[js.Any] = js.undefined,
    warning: js.UndefOr[Boolean] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (as.isDefined) {p.as = as}
    if (attached.isDefined) {p.attached = attached.map(v => v.value)}
    if (autoSuccess.isDefined) {p.autoSuccess = autoSuccess}
    if (className.isDefined) {p.className = className}
    if (color.isDefined) {p.color = color.map(v => v.value)}
    if (content.isDefined) {p.content = content}
    if (disabled.isDefined) {p.disabled = disabled}
    if (error.isDefined) {p.error = error}
    if (indicating.isDefined) {p.indicating = indicating}
    if (inverted.isDefined) {p.inverted = inverted}
    if (key.isDefined) {p.key = key}
    if (label.isDefined) {p.label = label}
    if (percent.isDefined) {p.percent = percent}
    if (precision.isDefined) {p.precision = precision}
    if (progress.isDefined) {p.progress = progress}
    if (size.isDefined) {p.size = size.map(v => v.value)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (success.isDefined) {p.success = success}
    if (total.isDefined) {p.total = total}
    if (value.isDefined) {p.value = value}
    if (warning.isDefined) {p.warning = warning}

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
        