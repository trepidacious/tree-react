
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Payment {

  @JSImport("@material-ui/icons/Payment", JSImport.Default)
  @js.native
  object PaymentJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PaymentJS)
  
  def apply() = jsFnComponent()

}
    