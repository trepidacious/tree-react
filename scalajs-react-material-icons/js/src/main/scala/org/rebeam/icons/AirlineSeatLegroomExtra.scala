
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AirlineSeatLegroomExtra {

  @JSImport("@material-ui/icons/AirlineSeatLegroomExtra", JSImport.Default)
  @js.native
  object AirlineSeatLegroomExtraJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AirlineSeatLegroomExtraJS)
  
  def apply() = jsFnComponent()

}
    