
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Loyalty {

  @JSImport("@material-ui/icons/Loyalty", JSImport.Default)
  @js.native
  object LoyaltyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LoyaltyJS)
  
  def apply() = jsFnComponent()

}
    