
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AirlineSeatFlatAngled {

  @JSImport("@material-ui/icons/AirlineSeatFlatAngled", JSImport.Default)
  @js.native
  object AirlineSeatFlatAngledJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AirlineSeatFlatAngledJS)
  
  def apply() = jsFnComponent()

}
    