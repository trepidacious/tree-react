
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhonelinkLock {

  @JSImport("@material-ui/icons/PhonelinkLock", JSImport.Default)
  @js.native
  object PhonelinkLockJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhonelinkLockJS)
  
  def apply() = jsFnComponent()

}
    