
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DepartureBoard {

  @JSImport("@material-ui/icons/DepartureBoard", JSImport.Default)
  @js.native
  object DepartureBoardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DepartureBoardJS)
  
  def apply() = jsFnComponent()

}
    