
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhonelinkErase {

  @JSImport("@material-ui/icons/PhonelinkErase", JSImport.Default)
  @js.native
  object PhonelinkEraseJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhonelinkEraseJS)
  
  def apply() = jsFnComponent()

}
    