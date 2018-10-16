
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalWifi1BarLock {

  @JSImport("@material-ui/icons/SignalWifi1BarLock", JSImport.Default)
  @js.native
  object SignalWifi1BarLockJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalWifi1BarLockJS)
  
  def apply() = jsFnComponent()

}
    