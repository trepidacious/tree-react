
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalGasStation {

  @JSImport("@material-ui/icons/LocalGasStation", JSImport.Default)
  @js.native
  object LocalGasStationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalGasStationJS)
  
  def apply() = jsFnComponent()

}
    