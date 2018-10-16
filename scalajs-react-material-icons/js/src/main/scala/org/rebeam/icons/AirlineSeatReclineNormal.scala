
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AirlineSeatReclineNormal {

  @JSImport("@material-ui/icons/AirlineSeatReclineNormal", JSImport.Default)
  @js.native
  object AirlineSeatReclineNormalJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AirlineSeatReclineNormalJS)
  
  def apply() = jsFnComponent()

}
    