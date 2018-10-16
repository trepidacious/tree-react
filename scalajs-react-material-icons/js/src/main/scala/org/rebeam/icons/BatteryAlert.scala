
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BatteryAlert {

  @JSImport("@material-ui/icons/BatteryAlert", JSImport.Default)
  @js.native
  object BatteryAlertJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BatteryAlertJS)
  
  def apply() = jsFnComponent()

}
    