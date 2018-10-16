
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Bluetooth {

  @JSImport("@material-ui/icons/Bluetooth", JSImport.Default)
  @js.native
  object BluetoothJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BluetoothJS)
  
  def apply() = jsFnComponent()

}
    