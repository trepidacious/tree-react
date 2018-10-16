
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RemoveShoppingCart {

  @JSImport("@material-ui/icons/RemoveShoppingCart", JSImport.Default)
  @js.native
  object RemoveShoppingCartJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RemoveShoppingCartJS)
  
  def apply() = jsFnComponent()

}
    