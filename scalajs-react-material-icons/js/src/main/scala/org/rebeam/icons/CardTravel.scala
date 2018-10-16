
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CardTravel {

  @JSImport("@material-ui/icons/CardTravel", JSImport.Default)
  @js.native
  object CardTravelJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CardTravelJS)
  
  def apply() = jsFnComponent()

}
    