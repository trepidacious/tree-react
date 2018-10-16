
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object EvStation {

  @JSImport("@material-ui/icons/EvStation", JSImport.Default)
  @js.native
  object EvStationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EvStationJS)
  
  def apply() = jsFnComponent()

}
    