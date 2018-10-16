
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AccessAlarms {

  @JSImport("@material-ui/icons/AccessAlarms", JSImport.Default)
  @js.native
  object AccessAlarmsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AccessAlarmsJS)
  
  def apply() = jsFnComponent()

}
    