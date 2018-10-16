
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Nfc {

  @JSImport("@material-ui/icons/Nfc", JSImport.Default)
  @js.native
  object NfcJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NfcJS)
  
  def apply() = jsFnComponent()

}
    