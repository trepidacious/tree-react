
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NotificationsActive {

  @JSImport("@material-ui/icons/NotificationsActive", JSImport.Default)
  @js.native
  object NotificationsActiveJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NotificationsActiveJS)
  
  def apply() = jsFnComponent()

}
    