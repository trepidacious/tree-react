
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Directions {

  @JSImport("@material-ui/icons/Directions", JSImport.Default)
  @js.native
  object DirectionsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DirectionsJS)
  
  def apply() = jsFnComponent()

}
    