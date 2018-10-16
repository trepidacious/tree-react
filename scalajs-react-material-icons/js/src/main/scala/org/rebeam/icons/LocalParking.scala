
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalParking {

  @JSImport("@material-ui/icons/LocalParking", JSImport.Default)
  @js.native
  object LocalParkingJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalParkingJS)
  
  def apply() = jsFnComponent()

}
    