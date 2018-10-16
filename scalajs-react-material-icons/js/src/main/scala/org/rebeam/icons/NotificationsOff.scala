
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NotificationsOff {

  @JSImport("@material-ui/icons/NotificationsOff", JSImport.Default)
  @js.native
  object NotificationsOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NotificationsOffJS)
  
  def apply() = jsFnComponent()

}
    