
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NetworkWifi {

  @JSImport("@material-ui/icons/NetworkWifi", JSImport.Default)
  @js.native
  object NetworkWifiJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NetworkWifiJS)
  
  def apply() = jsFnComponent()

}
    