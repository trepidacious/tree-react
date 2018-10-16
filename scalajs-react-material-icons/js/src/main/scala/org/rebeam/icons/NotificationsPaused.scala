
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NotificationsPaused {

  @JSImport("@material-ui/icons/NotificationsPaused", JSImport.Default)
  @js.native
  object NotificationsPausedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NotificationsPausedJS)
  
  def apply() = jsFnComponent()

}
    