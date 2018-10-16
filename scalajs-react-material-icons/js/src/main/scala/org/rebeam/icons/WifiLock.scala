
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WifiLock {

  @JSImport("@material-ui/icons/WifiLock", JSImport.Default)
  @js.native
  object WifiLockJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WifiLockJS)
  
  def apply() = jsFnComponent()

}
    