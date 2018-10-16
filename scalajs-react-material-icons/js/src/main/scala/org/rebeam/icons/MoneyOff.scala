
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MoneyOff {

  @JSImport("@material-ui/icons/MoneyOff", JSImport.Default)
  @js.native
  object MoneyOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MoneyOffJS)
  
  def apply() = jsFnComponent()

}
    