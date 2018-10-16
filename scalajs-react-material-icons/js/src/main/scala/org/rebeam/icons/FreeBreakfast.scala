
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FreeBreakfast {

  @JSImport("@material-ui/icons/FreeBreakfast", JSImport.Default)
  @js.native
  object FreeBreakfastJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FreeBreakfastJS)
  
  def apply() = jsFnComponent()

}
    