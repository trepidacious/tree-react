
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NextWeek {

  @JSImport("@material-ui/icons/NextWeek", JSImport.Default)
  @js.native
  object NextWeekJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NextWeekJS)
  
  def apply() = jsFnComponent()

}
    