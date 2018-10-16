
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AddShoppingCart {

  @JSImport("@material-ui/icons/AddShoppingCart", JSImport.Default)
  @js.native
  object AddShoppingCartJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddShoppingCartJS)
  
  def apply() = jsFnComponent()

}
    