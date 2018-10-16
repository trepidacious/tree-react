
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BluetoothSearching {

  @JSImport("@material-ui/icons/BluetoothSearching", JSImport.Default)
  @js.native
  object BluetoothSearchingJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BluetoothSearchingJS)
  
  def apply() = jsFnComponent()

}
    