
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CalendarToday {

  @JSImport("@material-ui/icons/CalendarToday", JSImport.Default)
  @js.native
  object CalendarTodayJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CalendarTodayJS)
  
  def apply() = jsFnComponent()

}
    