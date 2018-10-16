
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object StepButton {
  
  sealed trait Orientation{ val value: String }

  object Orientation {
    case object Horizontal extends Orientation { val value: String = "horizontal" }
    case object Vertical extends Orientation { val value: String = "vertical" }
  }
          
  @js.native
  trait Props extends js.Object {
    var TouchRippleProps: js.UndefOr[js.Object] = js.native
    var action: js.UndefOr[js.Any] = js.native
    var active: js.UndefOr[Boolean] = js.native
    var alternativeLabel: js.UndefOr[Boolean] = js.native
    var buttonRef: js.UndefOr[js.Any] = js.native
    var centerRipple: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var completed: js.UndefOr[Boolean] = js.native
    var component: js.UndefOr[js.Any] = js.native
    var disableRipple: js.UndefOr[Boolean] = js.native
    var disableTouchRipple: js.UndefOr[Boolean] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var focusRipple: js.UndefOr[Boolean] = js.native
    var focusVisibleClassName: js.UndefOr[String] = js.native
    var icon: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var key: js.UndefOr[String] = js.native
    var last: js.UndefOr[Boolean] = js.native
    var onBlur: js.UndefOr[scalajs.js.Function1[ReactFocusEvent, Unit]] = js.native
    var onClick: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var onFocus: js.UndefOr[scalajs.js.Function1[ReactFocusEvent, Unit]] = js.native
    var onFocusVisible: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onKeyDown: js.UndefOr[scalajs.js.Function1[ReactKeyboardEvent, Unit]] = js.native
    var onKeyUp: js.UndefOr[scalajs.js.Function1[ReactKeyboardEvent, Unit]] = js.native
    var onMouseDown: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var onMouseLeave: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var onMouseUp: js.UndefOr[scalajs.js.Function1[ReactMouseEvent, Unit]] = js.native
    var onTouchEnd: js.UndefOr[scalajs.js.Function1[ReactTouchEvent, Unit]] = js.native
    var onTouchMove: js.UndefOr[scalajs.js.Function1[ReactTouchEvent, Unit]] = js.native
    var onTouchStart: js.UndefOr[scalajs.js.Function1[ReactTouchEvent, Unit]] = js.native
    var optional: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var orientation: js.UndefOr[String] = js.native
    var role: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var tabIndex: js.UndefOr[js.Any] = js.native
    var `type`: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/StepButton", JSImport.Default)
  @js.native
  object StepButtonJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](StepButtonJS)
  
  /**
   * 
   * @param TouchRippleProps
   *        Properties applied to the `TouchRipple` element.
   *        Passed to ButtonBase
   * @param action
   *        Callback fired when the component mounts.
   *        This is useful when you want to trigger an action programmatically.
   *        It currently only supports `focusVisible()` action.
   *        
   *        parameter {object} actions This object contains all possible actions
   *        that can be triggered programmatically.
   *        Passed to ButtonBase
   * @param active
   *        Property spread to root element
   *        Passed in via `Step` - passed through to `StepLabel`.
   * @param alternativeLabel
   *        Property spread to root element
   *        Set internally by Stepper when it's supplied with the alternativeLabel property.
   * @param buttonRef
   *        Use that property to pass a ref callback to the native button component.
   *        Passed to ButtonBase
   * @param centerRipple
   *        If `true`, the ripples will be centered.
   *        They won't start at the cursor interaction position.
   *        Passed to ButtonBase
   * @param children
   *        Can be a `StepLabel` or a node to place inside `StepLabel` as children.
   * @param className
   *        Property spread to root element
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param completed
   *        Property spread to root element
   *        Sets completed styling. Is passed to StepLabel.
   * @param component
   *        The component used for the root node.
   *        Either a string to use a DOM element or a component.
   *        Passed to ButtonBase
   * @param disableRipple
   *        If `true`, the ripple effect will be disabled.
   *        Passed to ButtonBase
   * @param disableTouchRipple
   *        If `true`, the touch ripple effect will be disabled.
   *        Passed to ButtonBase
   * @param disabled
   *        Property spread to root element
   *        Disables the button and sets disabled styling. Is passed to StepLabel.
   * @param focusRipple
   *        If `true`, the base button will have a keyboard focus ripple.
   *        `disableRipple` must also be `false`.
   *        Passed to ButtonBase
   * @param focusVisibleClassName
   *        This property can help a person know which element has the keyboard focus.
   *        The class name will be applied when the element gain the focus through a keyboard interaction.
   *        It's a polyfill for the [CSS :focus-visible feature](https://drafts.csswg.org/selectors-4/#the-focus-visible-pseudo).
   *        The rational for using this feature [is explain here](https://github.com/WICG/focus-visible/blob/master/explainer.md).
   *        Passed to ButtonBase
   * @param icon
   *        The icon displayed by the step label.
   * @param key
   *        React key
   * @param last
   *        Property spread to root element
   * @param onBlur
   *        Property spread to root element
   *        Passed to ButtonBase
   * @param onClick
   *        Property spread to root element
   *        Passed to ButtonBase
   * @param onFocus
   *        Property spread to root element
   *        Passed to ButtonBase
   * @param onFocusVisible
   *        Callback fired when the component is focused with a keyboard.
   *        We trigger a `onFocus` callback too.
   *        Passed to ButtonBase
   * @param onKeyDown
   *        Property spread to root element
   *        Passed to ButtonBase
   * @param onKeyUp
   *        Property spread to root element
   *        Passed to ButtonBase
   * @param onMouseDown
   *        Property spread to root element
   *        Passed to ButtonBase
   * @param onMouseLeave
   *        Property spread to root element
   *        Passed to ButtonBase
   * @param onMouseUp
   *        Property spread to root element
   *        Passed to ButtonBase
   * @param onTouchEnd
   *        Property spread to root element
   *        Passed to ButtonBase
   * @param onTouchMove
   *        Property spread to root element
   *        Passed to ButtonBase
   * @param onTouchStart
   *        Property spread to root element
   *        Passed to ButtonBase
   * @param optional
   *        The optional node to display.
   * @param orientation
   *        Property spread to root element
   * @param role
   *        Property spread to root element
   *        Passed to ButtonBase
   * @param style
   *        React element CSS style
   * @param tabIndex
   *        Property spread to root element
   *        Passed to ButtonBase
   * @param `type`
   *        Used to control the button's purpose.
   *        This property passes the value to the `type` attribute of the native button component.
   *        Valid property values include `button`, `submit`, and `reset`.
   *        Passed to ButtonBase
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
    TouchRippleProps: js.UndefOr[js.Object] = js.undefined,
    action: js.UndefOr[js.Any] = js.undefined,
    active: js.UndefOr[Boolean] = js.undefined,
    alternativeLabel: js.UndefOr[Boolean] = js.undefined,
    buttonRef: js.UndefOr[js.Any] = js.undefined,
    centerRipple: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    completed: js.UndefOr[Boolean] = js.undefined,
    component: js.UndefOr[js.Any] = js.undefined,
    disableRipple: js.UndefOr[Boolean] = js.undefined,
    disableTouchRipple: js.UndefOr[Boolean] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    focusRipple: js.UndefOr[Boolean] = js.undefined,
    focusVisibleClassName: js.UndefOr[String] = js.undefined,
    icon: js.UndefOr[VdomNode] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    last: js.UndefOr[Boolean] = js.undefined,
    onBlur: js.UndefOr[ReactFocusEvent => Callback] = js.undefined,
    onClick: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    onFocus: js.UndefOr[ReactFocusEvent => Callback] = js.undefined,
    onFocusVisible: js.UndefOr[Callback] = js.undefined,
    onKeyDown: js.UndefOr[ReactKeyboardEvent => Callback] = js.undefined,
    onKeyUp: js.UndefOr[ReactKeyboardEvent => Callback] = js.undefined,
    onMouseDown: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    onMouseLeave: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    onMouseUp: js.UndefOr[ReactMouseEvent => Callback] = js.undefined,
    onTouchEnd: js.UndefOr[ReactTouchEvent => Callback] = js.undefined,
    onTouchMove: js.UndefOr[ReactTouchEvent => Callback] = js.undefined,
    onTouchStart: js.UndefOr[ReactTouchEvent => Callback] = js.undefined,
    optional: js.UndefOr[VdomNode] = js.undefined,
    orientation: js.UndefOr[Orientation] = js.undefined,
    role: js.UndefOr[String] = js.undefined,
    style: js.UndefOr[org.rebeam.mui.styles.Style] = js.undefined,
    tabIndex: js.UndefOr[js.Any] = js.undefined,
    `type`: js.UndefOr[String] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (TouchRippleProps.isDefined) {p.TouchRippleProps = TouchRippleProps}
    if (action.isDefined) {p.action = action}
    if (active.isDefined) {p.active = active}
    if (alternativeLabel.isDefined) {p.alternativeLabel = alternativeLabel}
    if (buttonRef.isDefined) {p.buttonRef = buttonRef}
    if (centerRipple.isDefined) {p.centerRipple = centerRipple}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (completed.isDefined) {p.completed = completed}
    if (component.isDefined) {p.component = component}
    if (disableRipple.isDefined) {p.disableRipple = disableRipple}
    if (disableTouchRipple.isDefined) {p.disableTouchRipple = disableTouchRipple}
    if (disabled.isDefined) {p.disabled = disabled}
    if (focusRipple.isDefined) {p.focusRipple = focusRipple}
    if (focusVisibleClassName.isDefined) {p.focusVisibleClassName = focusVisibleClassName}
    if (icon.isDefined) {p.icon = icon.map(v => v.rawNode)}
    if (key.isDefined) {p.key = key}
    if (last.isDefined) {p.last = last}
    if (onBlur.isDefined) {p.onBlur = onBlur.map(v => (e: ReactFocusEvent) => v(e).runNow())}
    if (onClick.isDefined) {p.onClick = onClick.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (onFocus.isDefined) {p.onFocus = onFocus.map(v => (e: ReactFocusEvent) => v(e).runNow())}
    if (onFocusVisible.isDefined) {p.onFocusVisible = onFocusVisible.map(v => v.toJsFn)}
    if (onKeyDown.isDefined) {p.onKeyDown = onKeyDown.map(v => (e: ReactKeyboardEvent) => v(e).runNow())}
    if (onKeyUp.isDefined) {p.onKeyUp = onKeyUp.map(v => (e: ReactKeyboardEvent) => v(e).runNow())}
    if (onMouseDown.isDefined) {p.onMouseDown = onMouseDown.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (onMouseLeave.isDefined) {p.onMouseLeave = onMouseLeave.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (onMouseUp.isDefined) {p.onMouseUp = onMouseUp.map(v => (e: ReactMouseEvent) => v(e).runNow())}
    if (onTouchEnd.isDefined) {p.onTouchEnd = onTouchEnd.map(v => (e: ReactTouchEvent) => v(e).runNow())}
    if (onTouchMove.isDefined) {p.onTouchMove = onTouchMove.map(v => (e: ReactTouchEvent) => v(e).runNow())}
    if (onTouchStart.isDefined) {p.onTouchStart = onTouchStart.map(v => (e: ReactTouchEvent) => v(e).runNow())}
    if (optional.isDefined) {p.optional = optional.map(v => v.rawNode)}
    if (orientation.isDefined) {p.orientation = orientation.map(v => v.value)}
    if (role.isDefined) {p.role = role}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (tabIndex.isDefined) {p.tabIndex = tabIndex}
    if (`type`.isDefined) {p.`type` = `type`}

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
        