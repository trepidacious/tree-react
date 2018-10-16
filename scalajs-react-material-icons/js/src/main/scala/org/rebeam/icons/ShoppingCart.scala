
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ShoppingCart {

  @JSImport("@material-ui/icons/ShoppingCart", JSImport.Default)
  @js.native
  object ShoppingCartJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ShoppingCartJS)
  
  def apply() = jsFnComponent()

}
    