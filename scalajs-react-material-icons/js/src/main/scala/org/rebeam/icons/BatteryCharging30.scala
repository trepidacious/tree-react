
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BatteryCharging30 {

  @JSImport("@material-ui/icons/BatteryCharging30", JSImport.Default)
  @js.native
  object BatteryCharging30JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BatteryCharging30JS)
  
  def apply() = jsFnComponent()

}
    