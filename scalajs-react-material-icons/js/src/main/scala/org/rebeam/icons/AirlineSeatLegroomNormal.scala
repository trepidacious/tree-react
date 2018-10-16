
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AirlineSeatLegroomNormal {

  @JSImport("@material-ui/icons/AirlineSeatLegroomNormal", JSImport.Default)
  @js.native
  object AirlineSeatLegroomNormalJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AirlineSeatLegroomNormalJS)
  
  def apply() = jsFnComponent()

}
    