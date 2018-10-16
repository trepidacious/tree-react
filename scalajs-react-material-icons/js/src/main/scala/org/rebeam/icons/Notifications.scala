
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Notifications {

  @JSImport("@material-ui/icons/Notifications", JSImport.Default)
  @js.native
  object NotificationsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NotificationsJS)
  
  def apply() = jsFnComponent()

}
    