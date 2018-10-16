
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ShopTwo {

  @JSImport("@material-ui/icons/ShopTwo", JSImport.Default)
  @js.native
  object ShopTwoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ShopTwoJS)
  
  def apply() = jsFnComponent()

}
    