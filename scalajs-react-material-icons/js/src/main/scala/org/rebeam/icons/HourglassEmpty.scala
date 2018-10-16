
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HourglassEmpty {

  @JSImport("@material-ui/icons/HourglassEmpty", JSImport.Default)
  @js.native
  object HourglassEmptyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HourglassEmptyJS)
  
  def apply() = jsFnComponent()

}
    