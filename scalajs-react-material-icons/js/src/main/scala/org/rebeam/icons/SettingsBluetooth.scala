
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsBluetooth {

  @JSImport("@material-ui/icons/SettingsBluetooth", JSImport.Default)
  @js.native
  object SettingsBluetoothJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsBluetoothJS)
  
  def apply() = jsFnComponent()

}
    