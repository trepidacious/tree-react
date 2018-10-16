
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HourglassFull {

  @JSImport("@material-ui/icons/HourglassFull", JSImport.Default)
  @js.native
  object HourglassFullJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HourglassFullJS)
  
  def apply() = jsFnComponent()

}
    