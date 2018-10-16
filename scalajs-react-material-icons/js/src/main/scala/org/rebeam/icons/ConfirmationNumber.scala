
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ConfirmationNumber {

  @JSImport("@material-ui/icons/ConfirmationNumber", JSImport.Default)
  @js.native
  object ConfirmationNumberJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ConfirmationNumberJS)
  
  def apply() = jsFnComponent()

}
    