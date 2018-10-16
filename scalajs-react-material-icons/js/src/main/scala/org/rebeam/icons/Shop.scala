
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Shop {

  @JSImport("@material-ui/icons/Shop", JSImport.Default)
  @js.native
  object ShopJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ShopJS)
  
  def apply() = jsFnComponent()

}
    