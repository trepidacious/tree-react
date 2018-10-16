
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Alarm {

  @JSImport("@material-ui/icons/Alarm", JSImport.Default)
  @js.native
  object AlarmJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AlarmJS)
  
  def apply() = jsFnComponent()

}
    