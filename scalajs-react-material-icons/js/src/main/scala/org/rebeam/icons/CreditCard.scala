
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CreditCard {

  @JSImport("@material-ui/icons/CreditCard", JSImport.Default)
  @js.native
  object CreditCardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CreditCardJS)
  
  def apply() = jsFnComponent()

}
    