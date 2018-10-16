
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BluetoothDisabled {

  @JSImport("@material-ui/icons/BluetoothDisabled", JSImport.Default)
  @js.native
  object BluetoothDisabledJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BluetoothDisabledJS)
  
  def apply() = jsFnComponent()

}
    