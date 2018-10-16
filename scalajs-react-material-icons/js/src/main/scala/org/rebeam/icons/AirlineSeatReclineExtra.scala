
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AirlineSeatReclineExtra {

  @JSImport("@material-ui/icons/AirlineSeatReclineExtra", JSImport.Default)
  @js.native
  object AirlineSeatReclineExtraJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AirlineSeatReclineExtraJS)
  
  def apply() = jsFnComponent()

}
    