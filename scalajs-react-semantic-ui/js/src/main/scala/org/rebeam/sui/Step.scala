
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Step {
  
  @js.native
  trait Props extends js.Object {
    var active: js.UndefOr[Boolean] = js.native
    var as: js.UndefOr[String] = js.native
    var className: js.UndefOr[String] = js.native
    var completed: js.UndefOr[Boolean] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var description: js.UndefOr[js.Any] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var href: js.UndefOr[String] = js.native
    var icon: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var link: js.UndefOr[Boolean] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var ordered: js.UndefOr[Boolean] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var title: js.UndefOr[js.Any] = js.native
  }

  @JSImport("semantic-ui-react", "Step")
  @js.native
  object StepJS extends js.Object

  val jsComponent = JsComponent[Props, Children.Varargs, Null](StepJS)
  
  /**
   * A step shows the completion status of an activity in a series of activities.
   * @param active
   *        A step can be highlighted as active.
   * @param as
   *        An element type to render as (string or function).
   * @param children
   *        Primary content.
   * @param className
   *        Additional classes.
   * @param completed
   *        A step can show that a user has completed it.
   * @param content
   *        Shorthand for primary content.
   * @param description
   *        Shorthand for StepDescription.
   * @param disabled
   *        Show that the Loader is inactive.
   * @param href
   *        Render as an `a` tag instead of a `div` and adds the href attribute.
   * @param icon
   *        Shorthand for Icon.
   * @param key
   *        React key
   * @param link
   *        A step can be link.
   * @param onClick
   *        Called on click. When passed, the component will render as an `a`
   *        tag by default instead of a `div`.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param ordered
   *        A step can show a ordered sequence of steps. Passed from StepGroup.
   * @param style
   *        React element CSS style
   * @param title
   *        Shorthand for StepTitle.
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
    as: js.UndefOr[String] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    completed: js.UndefOr[Boolean] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    description: js.UndefOr[js.Any] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    href: js.UndefOr[String] = js.undefined,
    icon: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    link: js.UndefOr[Boolean] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    ordered: js.UndefOr[Boolean] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    title: js.UndefOr[js.Any] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (active.isDefined) {p.active = active}
    if (as.isDefined) {p.as = as}
    if (className.isDefined) {p.className = className}
    if (completed.isDefined) {p.completed = completed}
    if (content.isDefined) {p.content = content}
    if (description.isDefined) {p.description = description}
    if (disabled.isDefined) {p.disabled = disabled}
    if (href.isDefined) {p.href = href}
    if (icon.isDefined) {p.icon = icon}
    if (key.isDefined) {p.key = key}
    if (link.isDefined) {p.link = link}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (ordered.isDefined) {p.ordered = ordered}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (title.isDefined) {p.title = title}

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
        