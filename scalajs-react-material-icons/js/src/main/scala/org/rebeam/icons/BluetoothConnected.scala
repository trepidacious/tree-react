
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BluetoothConnected {

  @JSImport("@material-ui/icons/BluetoothConnected", JSImport.Default)
  @js.native
  object BluetoothConnectedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BluetoothConnectedJS)
  
  def apply() = jsFnComponent()

}
    