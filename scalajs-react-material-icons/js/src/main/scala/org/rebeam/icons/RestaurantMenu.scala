
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RestaurantMenu {

  @JSImport("@material-ui/icons/RestaurantMenu", JSImport.Default)
  @js.native
  object RestaurantMenuJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RestaurantMenuJS)
  
  def apply() = jsFnComponent()

}
    