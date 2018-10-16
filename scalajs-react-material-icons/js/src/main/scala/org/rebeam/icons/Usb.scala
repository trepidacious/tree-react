
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Usb {

  @JSImport("@material-ui/icons/Usb", JSImport.Default)
  @js.native
  object UsbJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](UsbJS)
  
  def apply() = jsFnComponent()

}
    