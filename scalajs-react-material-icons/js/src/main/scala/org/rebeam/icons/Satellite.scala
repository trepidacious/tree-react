
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Satellite {

  @JSImport("@material-ui/icons/Satellite", JSImport.Default)
  @js.native
  object SatelliteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SatelliteJS)
  
  def apply() = jsFnComponent()

}
    