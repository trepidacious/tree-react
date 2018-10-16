
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PermContactCalendar {

  @JSImport("@material-ui/icons/PermContactCalendar", JSImport.Default)
  @js.native
  object PermContactCalendarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PermContactCalendarJS)
  
  def apply() = jsFnComponent()

}
    