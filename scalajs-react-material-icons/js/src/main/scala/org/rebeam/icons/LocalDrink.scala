
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalDrink {

  @JSImport("@material-ui/icons/LocalDrink", JSImport.Default)
  @js.native
  object LocalDrinkJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalDrinkJS)
  
  def apply() = jsFnComponent()

}
    