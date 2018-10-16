
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AttachMoney {

  @JSImport("@material-ui/icons/AttachMoney", JSImport.Default)
  @js.native
  object AttachMoneyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AttachMoneyJS)
  
  def apply() = jsFnComponent()

}
    