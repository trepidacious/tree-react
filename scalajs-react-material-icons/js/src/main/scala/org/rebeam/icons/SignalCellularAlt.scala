
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalCellularAlt {

  @JSImport("@material-ui/icons/SignalCellularAlt", JSImport.Default)
  @js.native
  object SignalCellularAltJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalCellularAltJS)
  
  def apply() = jsFnComponent()

}
    