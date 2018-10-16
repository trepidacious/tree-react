
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalAirport {

  @JSImport("@material-ui/icons/LocalAirport", JSImport.Default)
  @js.native
  object LocalAirportJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalAirportJS)
  
  def apply() = jsFnComponent()

}
    