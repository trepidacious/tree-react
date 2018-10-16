
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DirectionsCar {

  @JSImport("@material-ui/icons/DirectionsCar", JSImport.Default)
  @js.native
  object DirectionsCarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DirectionsCarJS)
  
  def apply() = jsFnComponent()

}
    