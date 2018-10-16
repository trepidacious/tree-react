
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AirlineSeatFlat {

  @JSImport("@material-ui/icons/AirlineSeatFlat", JSImport.Default)
  @js.native
  object AirlineSeatFlatJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AirlineSeatFlatJS)
  
  def apply() = jsFnComponent()

}
    