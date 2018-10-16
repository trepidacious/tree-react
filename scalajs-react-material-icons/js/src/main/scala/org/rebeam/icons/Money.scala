
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Money {

  @JSImport("@material-ui/icons/Money", JSImport.Default)
  @js.native
  object MoneyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MoneyJS)
  
  def apply() = jsFnComponent()

}
    