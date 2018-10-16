
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BatteryChargingFull {

  @JSImport("@material-ui/icons/BatteryChargingFull", JSImport.Default)
  @js.native
  object BatteryChargingFullJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BatteryChargingFullJS)
  
  def apply() = jsFnComponent()

}
    