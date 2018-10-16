
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Hotel {

  @JSImport("@material-ui/icons/Hotel", JSImport.Default)
  @js.native
  object HotelJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HotelJS)
  
  def apply() = jsFnComponent()

}
    