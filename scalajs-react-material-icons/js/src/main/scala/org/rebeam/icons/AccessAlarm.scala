
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AccessAlarm {

  @JSImport("@material-ui/icons/AccessAlarm", JSImport.Default)
  @js.native
  object AccessAlarmJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AccessAlarmJS)
  
  def apply() = jsFnComponent()

}
    