
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BatteryFull {

  @JSImport("@material-ui/icons/BatteryFull", JSImport.Default)
  @js.native
  object BatteryFullJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BatteryFullJS)
  
  def apply() = jsFnComponent()

}
    