
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AirportShuttle {

  @JSImport("@material-ui/icons/AirportShuttle", JSImport.Default)
  @js.native
  object AirportShuttleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AirportShuttleJS)
  
  def apply() = jsFnComponent()

}
    