
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalWifi4BarLock {

  @JSImport("@material-ui/icons/SignalWifi4BarLock", JSImport.Default)
  @js.native
  object SignalWifi4BarLockJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalWifi4BarLockJS)
  
  def apply() = jsFnComponent()

}
    