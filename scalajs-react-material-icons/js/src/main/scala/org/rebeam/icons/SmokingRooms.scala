
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SmokingRooms {

  @JSImport("@material-ui/icons/SmokingRooms", JSImport.Default)
  @js.native
  object SmokingRoomsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SmokingRoomsJS)
  
  def apply() = jsFnComponent()

}
    