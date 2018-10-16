
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BatteryUnknown {

  @JSImport("@material-ui/icons/BatteryUnknown", JSImport.Default)
  @js.native
  object BatteryUnknownJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BatteryUnknownJS)
  
  def apply() = jsFnComponent()

}
    