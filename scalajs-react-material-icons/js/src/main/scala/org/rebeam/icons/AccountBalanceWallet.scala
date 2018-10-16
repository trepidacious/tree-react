
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AccountBalanceWallet {

  @JSImport("@material-ui/icons/AccountBalanceWallet", JSImport.Default)
  @js.native
  object AccountBalanceWalletJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AccountBalanceWalletJS)
  
  def apply() = jsFnComponent()

}
    