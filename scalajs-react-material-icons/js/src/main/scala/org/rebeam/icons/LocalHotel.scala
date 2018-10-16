
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalHotel {

  @JSImport("@material-ui/icons/LocalHotel", JSImport.Default)
  @js.native
  object LocalHotelJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalHotelJS)
  
  def apply() = jsFnComponent()

}
    