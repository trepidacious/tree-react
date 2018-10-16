
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AccountBalance {

  @JSImport("@material-ui/icons/AccountBalance", JSImport.Default)
  @js.native
  object AccountBalanceJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AccountBalanceJS)
  
  def apply() = jsFnComponent()

}
    