
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Redeem {

  @JSImport("@material-ui/icons/Redeem", JSImport.Default)
  @js.native
  object RedeemJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RedeemJS)
  
  def apply() = jsFnComponent()

}
    