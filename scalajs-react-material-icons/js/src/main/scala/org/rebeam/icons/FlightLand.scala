
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FlightLand {

  @JSImport("@material-ui/icons/FlightLand", JSImport.Default)
  @js.native
  object FlightLandJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FlightLandJS)
  
  def apply() = jsFnComponent()

}
    