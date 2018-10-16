
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Schedule {

  @JSImport("@material-ui/icons/Schedule", JSImport.Default)
  @js.native
  object ScheduleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ScheduleJS)
  
  def apply() = jsFnComponent()

}
    