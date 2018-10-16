
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SwapVerticalCircle {

  @JSImport("@material-ui/icons/SwapVerticalCircle", JSImport.Default)
  @js.native
  object SwapVerticalCircleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SwapVerticalCircleJS)
  
  def apply() = jsFnComponent()

}
    