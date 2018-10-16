
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalWifi3BarLock {

  @JSImport("@material-ui/icons/SignalWifi3BarLock", JSImport.Default)
  @js.native
  object SignalWifi3BarLockJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalWifi3BarLockJS)
  
  def apply() = jsFnComponent()

}
    