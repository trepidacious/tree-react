
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalCellularNoSim {

  @JSImport("@material-ui/icons/SignalCellularNoSim", JSImport.Default)
  @js.native
  object SignalCellularNoSimJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalCellularNoSimJS)
  
  def apply() = jsFnComponent()

}
    