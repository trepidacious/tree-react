
package org.rebeam.sui

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

import japgolly.scalajs.react.vdom.html_<^._

object Confirm {
  
  sealed trait Size{ val value: String }

  object Size {
    case object Mini extends Size { val value: String = "mini" }
    case object Tiny extends Size { val value: String = "tiny" }
    case object Small extends Size { val value: String = "small" }
    case object Fullscreen extends Size { val value: String = "fullscreen" }
    case object Large extends Size { val value: String = "large" }
  }
          
  @js.native
  trait Props extends js.Object {
    var cancelButton: js.UndefOr[js.Any] = js.native
    var confirmButton: js.UndefOr[js.Any] = js.native
    var content: js.UndefOr[js.Any] = js.native
    var header: js.UndefOr[js.Any] = js.native
    var key: js.UndefOr[String] = js.native
    var onCancel: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var onConfirm: js.UndefOr[scalajs.js.Function0[Unit]] = js.native
    var open: js.UndefOr[Boolean] = js.native
    var size: js.UndefOr[String] = js.native
    var style: js.UndefOr[js.Object] = js.native
  }

  @JSImport("semantic-ui-react", "Confirm")
  @js.native
  object ConfirmJS extends js.Object

  val jsComponent = JsComponent[Props, Children.None, Null](ConfirmJS)
  
  /**
   * A Confirm modal gives the user a choice to confirm or cancel an action/
   * @see Modal
   * @param cancelButton
   *        The cancel button text.
   * @param confirmButton
   *        The OK button text.
   * @param content
   *        The ModalContent text.
   * @param header
   *        The ModalHeader text.
   * @param key
   *        React key
   * @param onCancel
   *        Called when the Modal is closed without clicking confirm.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param onConfirm
   *        Called when the OK button is clicked.
   *        
   *        parameter {SyntheticEvent} event - React's original SyntheticEvent.
   *        parameter {object} data - All props.
   * @param open
   *        Whether or not the modal is visible.
   * @param size
   *        A Confirm can vary in size
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
    cancelButton: js.UndefOr[js.Any] = js.undefined,
    confirmButton: js.UndefOr[js.Any] = js.undefined,
    content: js.UndefOr[js.Any] = js.undefined,
    header: js.UndefOr[js.Any] = js.undefined,
    key: js.UndefOr[String] = js.undefined,
    onCancel: js.UndefOr[Callback] = js.undefined,
    onConfirm: js.UndefOr[Callback] = js.undefined,
    open: js.UndefOr[Boolean] = js.undefined,
    size: js.UndefOr[Size] = js.undefined,
    style: js.UndefOr[org.rebeam.react.Style] = js.undefined,
    additionalProps: js.UndefOr[js.Object] = js.undefined
  ) = {

    val p = (new js.Object).asInstanceOf[Props]
    if (cancelButton.isDefined) {p.cancelButton = cancelButton}
    if (confirmButton.isDefined) {p.confirmButton = confirmButton}
    if (content.isDefined) {p.content = content}
    if (header.isDefined) {p.header = header}
    if (key.isDefined) {p.key = key}
    if (onCancel.isDefined) {p.onCancel = onCancel.map(v => v.toJsFn)}
    if (onConfirm.isDefined) {p.onConfirm = onConfirm.map(v => v.toJsFn)}
    if (open.isDefined) {p.open = open}
    if (size.isDefined) {p.size = size.map(v => v.value)}
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
    
    jsComponent(p)
  }

}
        