
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object EventSeat {

  @JSImport("@material-ui/icons/EventSeat", JSImport.Default)
  @js.native
  object EventSeatJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EventSeatJS)
  
  def apply() = jsFnComponent()

}
    