
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CalendarViewDay {

  @JSImport("@material-ui/icons/CalendarViewDay", JSImport.Default)
  @js.native
  object CalendarViewDayJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CalendarViewDayJS)
  
  def apply() = jsFnComponent()

}
    