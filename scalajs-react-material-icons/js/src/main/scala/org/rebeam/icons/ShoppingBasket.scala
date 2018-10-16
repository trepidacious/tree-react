
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ShoppingBasket {

  @JSImport("@material-ui/icons/ShoppingBasket", JSImport.Default)
  @js.native
  object ShoppingBasketJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ShoppingBasketJS)
  
  def apply() = jsFnComponent()

}
    