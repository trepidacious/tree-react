
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VpnLock {

  @JSImport("@material-ui/icons/VpnLock", JSImport.Default)
  @js.native
  object VpnLockJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VpnLockJS)
  
  def apply() = jsFnComponent()

}
    