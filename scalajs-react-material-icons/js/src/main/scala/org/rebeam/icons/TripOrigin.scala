
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TripOrigin {

  @JSImport("@material-ui/icons/TripOrigin", JSImport.Default)
  @js.native
  object TripOriginJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TripOriginJS)
  
  def apply() = jsFnComponent()

}
    