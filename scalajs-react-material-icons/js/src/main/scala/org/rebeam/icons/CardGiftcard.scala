
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CardGiftcard {

  @JSImport("@material-ui/icons/CardGiftcard", JSImport.Default)
  @js.native
  object CardGiftcardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CardGiftcardJS)
  
  def apply() = jsFnComponent()

}
    