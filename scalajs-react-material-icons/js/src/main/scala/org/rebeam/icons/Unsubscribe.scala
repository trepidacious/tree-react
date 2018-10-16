
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Unsubscribe {

  @JSImport("@material-ui/icons/Unsubscribe", JSImport.Default)
  @js.native
  object UnsubscribeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](UnsubscribeJS)
  
  def apply() = jsFnComponent()

}
    