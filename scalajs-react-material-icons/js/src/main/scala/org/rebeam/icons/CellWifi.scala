
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CellWifi {

  @JSImport("@material-ui/icons/CellWifi", JSImport.Default)
  @js.native
  object CellWifiJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CellWifiJS)
  
  def apply() = jsFnComponent()

}
    