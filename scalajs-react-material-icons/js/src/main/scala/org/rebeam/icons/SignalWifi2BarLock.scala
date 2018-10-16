
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalWifi2BarLock {

  @JSImport("@material-ui/icons/SignalWifi2BarLock", JSImport.Default)
  @js.native
  object SignalWifi2BarLockJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalWifi2BarLockJS)
  
  def apply() = jsFnComponent()

}
    