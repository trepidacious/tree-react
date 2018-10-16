
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FlightTakeoff {

  @JSImport("@material-ui/icons/FlightTakeoff", JSImport.Default)
  @js.native
  object FlightTakeoffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FlightTakeoffJS)
  
  def apply() = jsFnComponent()

}
    