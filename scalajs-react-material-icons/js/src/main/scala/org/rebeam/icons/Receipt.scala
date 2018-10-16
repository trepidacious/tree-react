
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Receipt {

  @JSImport("@material-ui/icons/Receipt", JSImport.Default)
  @js.native
  object ReceiptJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ReceiptJS)
  
  def apply() = jsFnComponent()

}
    