
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SwapCalls {

  @JSImport("@material-ui/icons/SwapCalls", JSImport.Default)
  @js.native
  object SwapCallsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SwapCallsJS)
  
  def apply() = jsFnComponent()

}
    