
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NotificationsNone {

  @JSImport("@material-ui/icons/NotificationsNone", JSImport.Default)
  @js.native
  object NotificationsNoneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NotificationsNoneJS)
  
  def apply() = jsFnComponent()

}
    