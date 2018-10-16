
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BatteryStd {

  @JSImport("@material-ui/icons/BatteryStd", JSImport.Default)
  @js.native
  object BatteryStdJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BatteryStdJS)
  
  def apply() = jsFnComponent()

}
    