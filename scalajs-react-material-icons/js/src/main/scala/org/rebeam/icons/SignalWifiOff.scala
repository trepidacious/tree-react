
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalWifiOff {

  @JSImport("@material-ui/icons/SignalWifiOff", JSImport.Default)
  @js.native
  object SignalWifiOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalWifiOffJS)
  
  def apply() = jsFnComponent()

}
    