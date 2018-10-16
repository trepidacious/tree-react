
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Kitchen {

  @JSImport("@material-ui/icons/Kitchen", JSImport.Default)
  @js.native
  object KitchenJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](KitchenJS)
  
  def apply() = jsFnComponent()

}
    