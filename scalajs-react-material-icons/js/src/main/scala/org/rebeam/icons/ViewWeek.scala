
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ViewWeek {

  @JSImport("@material-ui/icons/ViewWeek", JSImport.Default)
  @js.native
  object ViewWeekJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ViewWeekJS)
  
  def apply() = jsFnComponent()

}
    