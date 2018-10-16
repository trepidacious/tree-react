
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalTaxi {

  @JSImport("@material-ui/icons/LocalTaxi", JSImport.Default)
  @js.native
  object LocalTaxiJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalTaxiJS)
  
  def apply() = jsFnComponent()

}
    