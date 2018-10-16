
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AddAlarm {

  @JSImport("@material-ui/icons/AddAlarm", JSImport.Default)
  @js.native
  object AddAlarmJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddAlarmJS)
  
  def apply() = jsFnComponent()

}
    