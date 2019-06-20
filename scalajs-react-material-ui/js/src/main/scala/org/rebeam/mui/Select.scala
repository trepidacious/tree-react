
package org.rebeam.mui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Select {
  
  sealed trait Margin{ val value: String }

  object Margin {
    case object Dense extends Margin { val value: String = "dense" }
    case object None extends Margin { val value: String = "none" }
  }
            
  sealed trait Variant{ val value: String }

  object Variant {
    case object Standard extends Variant { val value: String = "standard" }
    case object Outlined extends Variant { val value: String = "outlined" }
    case object Filled extends Variant { val value: String = "filled" }
  }
          
  @js.native
  trait Props extends js.Object {
    var IconComponent: js.UndefOr[js.Any] = js.native
    var MenuProps: js.UndefOr[js.Object] = js.native
    var SelectDisplayProps: js.UndefOr[js.Object] = js.native
    var autoComplete: js.UndefOr[String] = js.native
    var autoFocus: js.UndefOr[Boolean] = js.native
    var autoWidth: js.UndefOr[Boolean] = js.native
    var className: js.UndefOr[String] = js.native
    var classes: js.UndefOr[js.Object] = js.native
    var defaultValue: js.UndefOr[js.Any] = js.native
    var disableUnderline: js.UndefOr[Boolean] = js.native
    var disabled: js.UndefOr[Boolean] = js.native
    var displayEmpty: js.UndefOr[Boolean] = js.native
    var endAdornment: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var error: js.UndefOr[Boolean] = js.native
    var fullWidth: js.UndefOr[Boolean] = js.native
    var id: js.UndefOr[String] = js.native
    var input: js.UndefOr[japgolly.scalajs.react.raw.React.Element] = js.native
    var inputComponent: js.UndefOr[js.Any] = js.native
    var inputProps: js.UndefOr[js.Object] = js.native
    var inputRef: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var margin: js.UndefOr[String] = js.native
    var muiFormControl: js.UndefOr[js.Object] = js.native
    var multiline: js.UndefOr[Boolean] = js.native
    var multiple: js.UndefOr[Boolean] = js.native
    var name: js.UndefOr[String] = js.native
    var native: js.UndefOr[Boolean] = js.native
    var onBlur: js.UndefOr[scalajs.js.Function1[ReactFocusEvent, Unit]] = js.native
    var onChange: js.UndefOr[scalajs.js.Function1[ReactEvent, Unit]] = js.native
    var onClose: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onEmpty: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onFilled: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onFocus: js.UndefOr[scalajs.js.Function1[ReactFocusEvent, Unit]] = js.native
    var onKeyDown: js.UndefOr[scalajs.js.Function1[ReactKeyboardEvent, Unit]] = js.native
    var onKeyUp: js.UndefOr[scalajs.js.Function1[ReactKeyboardEvent, Unit]] = js.native
    var onOpen: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var open: js.UndefOr[Boolean] = js.native
    var placeholder: js.UndefOr[String] = js.native
    var readOnly: js.UndefOr[Boolean] = js.native
    var renderPrefix: js.UndefOr[js.Any] = js.native
    var renderValue: js.UndefOr[js.Any] = js.native
    var required: js.UndefOr[Boolean] = js.native
    var rows: js.UndefOr[js.Any] = js.native
    var rowsMax: js.UndefOr[js.Any] = js.native
    var startAdornment: js.UndefOr[japgolly.scalajs.react.raw.React.Node] = js.native
    var style: js.UndefOr[js.Object] = js.native
    var `type`: js.UndefOr[String] = js.native
    var value: js.UndefOr[js.Any] = js.native
    var variant: js.UndefOr[String] = js.native
  }

  @JSImport("@material-ui/core/Select", JSImport.Default)
  @js.native
  object SelectJS extends js.Object

  val jsComponent = JsFnComponent[Props, Children.Varargs](SelectJS)
  
  /**
   * 
   * @param IconComponent
   *        The icon that displays the arrow.
   * @param MenuProps
   *        Properties applied to the [`Menu`](/api/menu/) element.
   * @param SelectDisplayProps
   *        Properties applied to the clickable div element.
   * @param autoComplete
   *        This property helps users to fill forms faster, especially on mobile devices.
   *        The name can be confusing, as it's more like an autofill.
   *        You can learn more about it here:
   *        https://html.spec.whatwg.org/multipage/form-control-infrastructure.html#autofill
   *        Passed to Input
   * @param autoFocus
   *        If `true`, the input will be focused during the first mount.
   *        Passed to Input
   * @param autoWidth
   *        If true, the width of the popover will automatically be set according to the items inside the
   *        menu, otherwise it will be at least the width of the select input.
   * @param children
   *        The option elements to populate the select with.
   *        Can be some `MenuItem` when `native` is false and `option` when `native` is true.
   * @param className
   *        The CSS class name of the wrapper element.
   *        Passed to Input
   * @param classes
   *        Override or extend the styles applied to the component.
   *        See [CSS API](#css-api) below for more details.
   * @param defaultValue
   *        The default input value, useful when not controlling the component.
   *        Passed to Input
   * @param disableUnderline
   *        If `true`, the input will not have an underline.
   *        Passed to Input
   * @param disabled
   *        If `true`, the input will be disabled.
   *        Passed to Input
   * @param displayEmpty
   *        If `true`, the selected item is displayed even if its value is empty.
   *        You can only use it when the `native` property is `false` (default).
   * @param endAdornment
   *        End `InputAdornment` for this component.
   *        Passed to Input
   * @param error
   *        If `true`, the input will indicate an error. This is normally obtained via context from
   *        FormControl.
   *        Passed to Input
   * @param fullWidth
   *        If `true`, the input will take up the full width of its container.
   *        Passed to Input
   * @param id
   *        The id of the `input` element.
   *        Passed to Input
   * @param input
   *        An `Input` element; does not have to be a material-ui specific `Input`.
   * @param inputComponent
   *        The component used for the native input.
   *        Either a string to use a DOM element or a component.
   *        Passed to Input
   * @param inputProps
   *        Attributes applied to the `input` element.
   *        When `native` is `true`, the attributes are applied on the `select` element.
   * @param inputRef
   *        Use that property to pass a ref callback to the native input component.
   *        Passed to Input
   * @param key
   *        React key
   * @param margin
   *        If `dense`, will adjust vertical spacing. This is normally obtained via context from
   *        FormControl.
   *        Passed to Input
   * @param muiFormControl
   *        Property spread to root element
   *        Passed to InputBase
   * @param multiline
   *        If `true`, a textarea element will be rendered.
   *        Passed to Input
   * @param multiple
   *        If true, `value` must be an array and the menu will support multiple selections.
   * @param name
   *        Name attribute of the `input` element.
   *        Passed to Input
   * @param native
   *        If `true`, the component will be using a native `select` element.
   * @param onBlur
   *        Property spread to root element
   *        Passed to InputBase
   * @param onChange
   *        Callback function fired when a menu item is selected.
   *        
   *        parameter {object} event The event source of the callback.
   *        You can pull out the new value by accessing `event.target.value`.
   *        parameter {object} [child] The react element that was selected when `native` is `false` (default).
   * @param onClose
   *        Callback fired when the component requests to be closed.
   *        Use in controlled mode (see open).
   *        
   *        parameter {object} event The event source of the callback
   * @param onEmpty
   *        Property spread to root element
   *        Passed to InputBase
   * @param onFilled
   *        Property spread to root element
   *        Passed to InputBase
   * @param onFocus
   *        Property spread to root element
   *        Passed to InputBase
   * @param onKeyDown
   *        Property spread to root element
   *        Passed to InputBase
   * @param onKeyUp
   *        Property spread to root element
   *        Passed to InputBase
   * @param onOpen
   *        Callback fired when the component requests to be opened.
   *        Use in controlled mode (see open).
   *        
   *        parameter {object} event The event source of the callback
   * @param open
   *        Control `select` open state.
   *        You can only use it when the `native` property is `false` (default).
   * @param placeholder
   *        The short hint displayed in the input before the user enters a value.
   *        Passed to Input
   * @param readOnly
   *        It prevents the user from changing the value of the field
   *        (not from interacting with the field).
   *        Passed to Input
   * @param renderPrefix
   *        Property spread to root element
   *        Passed to InputBase
   * @param renderValue
   *        Render the selected value.
   *        You can only use it when the `native` property is `false` (default).
   *        
   *        parameter {*} value The `value` provided to the component.
   *        returns {ReactElement}
   * @param required
   *        If `true`, the input will be required.
   *        Passed to Input
   * @param rows
   *        Number of rows to display when multiline option is set to true.
   *        Passed to Input
   * @param rowsMax
   *        Maximum number of rows to display when multiline option is set to true.
   *        Passed to Input
   * @param startAdornment
   *        Start `InputAdornment` for this component.
   *        Passed to Input
   * @param style
   *        React element CSS style
   * @param `type`
   *        Type of the input element. It should be a valid HTML5 input type.
   *        Passed to Input
   * @param value
   *        The input value.
   *        This property is required when the `native` property is `false` (default).
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
    IconComponent: js.UndefOr[js.Any] = js.undefined,
    MenuProps: js.UndefOr[js.Object] = js.undefined,
    SelectDisplayProps: js.UndefOr[js.Object] = js.undefined,
    autoComplete: js.UndefOr[String] = js.undefined,
    autoFocus: js.UndefOr[Boolean] = js.undefined,
    autoWidth: js.UndefOr[Boolean] = js.undefined,
    className: js.UndefOr[String] = js.undefined,
    classes: js.UndefOr[js.Object] = js.undefined,
    defaultValue: js.UndefOr[js.Any] = js.undefined,
    disableUnderline: js.UndefOr[Boolean] = js.undefined,
    disabled: js.UndefOr[Boolean] = js.undefined,
    displayEmpty: js.UndefOr[Boolean] = js.undefined,
    endAdornment: js.UndefOr[VdomNode] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    fullWidth: js.UndefOr[Boolean] = js.undefined,
    id: js.UndefOr[String] = js.undefined,
    input: js.UndefOr[VdomElement] = js.undefined,
    inputComponent: js.UndefOr[js.Any] = js.undefined,
    inputProps: js.UndefOr[js.Object] = js.undefined,
    inputRef: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    margin: js.UndefOr[Margin] = js.undefined,
    muiFormControl: js.UndefOr[js.Object] = js.undefined,
    multiline: js.UndefOr[Boolean] = js.undefined,
    multiple: js.UndefOr[Boolean] = js.undefined,
    name: js.UndefOr[String] = js.undefined,
    native: js.UndefOr[Boolean] = js.undefined,
    onBlur: js.UndefOr[ReactFocusEvent => Callback] = js.undefined,
    onChange: js.UndefOr[ReactEvent => Callback] = js.undefined,
    onClose: js.UndefOr[Callback] = js.undefined,
    onEmpty: js.UndefOr[Callback] = js.undefined,
    onFilled: js.UndefOr[Callback] = js.undefined,
    onFocus: js.UndefOr[ReactFocusEvent => Callback] = js.undefined,
    onKeyDown: js.UndefOr[ReactKeyboardEvent => Callback] = js.undefined,
    onKeyUp: js.UndefOr[ReactKeyboardEvent => Callback] = js.undefined,
    onOpen: js.UndefOr[Callback] = js.undefined,
    open: js.UndefOr[Boolean] = js.undefined,
    placeholder: js.UndefOr[String] = js.undefined,
    readOnly: js.UndefOr[Boolean] = js.undefined,
    renderPrefix: js.UndefOr[js.Any] = js.undefined,
    renderValue: js.UndefOr[js.Any] = js.undefined,
    required: js.UndefOr[Boolean] = js.undefined,
    rows: js.UndefOr[js.Any] = js.undefined,
    rowsMax: js.UndefOr[js.Any] = js.undefined,
    startAdornment: js.UndefOr[VdomNode] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    `type`: js.UndefOr[String] = js.undefined,
    value: js.UndefOr[js.Any] = js.undefined,
    variant: js.UndefOr[Variant] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  )(children: VdomNode *) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (IconComponent.isDefined) {p.IconComponent = IconComponent}
    if (MenuProps.isDefined) {p.MenuProps = MenuProps}
    if (SelectDisplayProps.isDefined) {p.SelectDisplayProps = SelectDisplayProps}
    if (autoComplete.isDefined) {p.autoComplete = autoComplete}
    if (autoFocus.isDefined) {p.autoFocus = autoFocus}
    if (autoWidth.isDefined) {p.autoWidth = autoWidth}
    if (className.isDefined) {p.className = className}
    if (classes.isDefined) {p.classes = classes}
    if (defaultValue.isDefined) {p.defaultValue = defaultValue}
    if (disableUnderline.isDefined) {p.disableUnderline = disableUnderline}
    if (disabled.isDefined) {p.disabled = disabled}
    if (displayEmpty.isDefined) {p.displayEmpty = displayEmpty}
    if (endAdornment.isDefined) {p.endAdornment = endAdornment.map(v => v.rawNode)}
    if (error.isDefined) {p.error = error}
    if (fullWidth.isDefined) {p.fullWidth = fullWidth}
    if (id.isDefined) {p.id = id}
    if (input.isDefined) {p.input = input.map(v => v.rawElement)}
    if (inputComponent.isDefined) {p.inputComponent = inputComponent}
    if (inputProps.isDefined) {p.inputProps = inputProps}
    if (inputRef.isDefined) {p.inputRef = inputRef}
    if (key.isDefined) {p.key = key}
    if (margin.isDefined) {p.margin = margin.map(v => v.value)}
    if (muiFormControl.isDefined) {p.muiFormControl = muiFormControl}
    if (multiline.isDefined) {p.multiline = multiline}
    if (multiple.isDefined) {p.multiple = multiple}
    if (name.isDefined) {p.name = name}
    if (native.isDefined) {p.native = native}
    if (onBlur.isDefined) {p.onBlur = onBlur.map(v => (e: ReactFocusEvent) => v(e).runNow())}
    if (onChange.isDefined) {p.onChange = onChange.map(v => (e: ReactEvent) => v(e).runNow())}
    if (onClose.isDefined) {p.onClose = onClose.map(v => v.toJsFn)}
    if (onEmpty.isDefined) {p.onEmpty = onEmpty.map(v => v.toJsFn)}
    if (onFilled.isDefined) {p.onFilled = onFilled.map(v => v.toJsFn)}
    if (onFocus.isDefined) {p.onFocus = onFocus.map(v => (e: ReactFocusEvent) => v(e).runNow())}
    if (onKeyDown.isDefined) {p.onKeyDown = onKeyDown.map(v => (e: ReactKeyboardEvent) => v(e).runNow())}
    if (onKeyUp.isDefined) {p.onKeyUp = onKeyUp.map(v => (e: ReactKeyboardEvent) => v(e).runNow())}
    if (onOpen.isDefined) {p.onOpen = onOpen.map(v => v.toJsFn)}
    if (open.isDefined) {p.open = open}
    if (placeholder.isDefined) {p.placeholder = placeholder}
    if (readOnly.isDefined) {p.readOnly = readOnly}
    if (renderPrefix.isDefined) {p.renderPrefix = renderPrefix}
    if (renderValue.isDefined) {p.renderValue = renderValue}
    if (required.isDefined) {p.required = required}
    if (rows.isDefined) {p.rows = rows}
    if (rowsMax.isDefined) {p.rowsMax = rowsMax}
    if (startAdornment.isDefined) {p.startAdornment = startAdornment.map(v => v.rawNode)}
    if (style.isDefined) {p.style = style.map(v => v.o)}
    if (`type`.isDefined) {p.`type` = `type`}
    if (value.isDefined) {p.value = value}
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
        