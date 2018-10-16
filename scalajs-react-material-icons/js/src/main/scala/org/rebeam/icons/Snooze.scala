
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Snooze {

  @JSImport("@material-ui/icons/Snooze", JSImport.Default)
  @js.native
  object SnoozeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SnoozeJS)
  
  def apply() = jsFnComponent()

}
    