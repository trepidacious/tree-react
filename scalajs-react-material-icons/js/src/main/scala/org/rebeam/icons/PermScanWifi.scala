
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PermScanWifi {

  @JSImport("@material-ui/icons/PermScanWifi", JSImport.Default)
  @js.native
  object PermScanWifiJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PermScanWifiJS)
  
  def apply() = jsFnComponent()

}
    