
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Restaurant {

  @JSImport("@material-ui/icons/Restaurant", JSImport.Default)
  @js.native
  object RestaurantJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RestaurantJS)
  
  def apply() = jsFnComponent()

}
    