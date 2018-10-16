
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DirectionsBoat {

  @JSImport("@material-ui/icons/DirectionsBoat", JSImport.Default)
  @js.native
  object DirectionsBoatJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DirectionsBoatJS)
  
  def apply() = jsFnComponent()

}
    