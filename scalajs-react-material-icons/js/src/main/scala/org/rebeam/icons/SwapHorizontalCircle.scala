
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SwapHorizontalCircle {

  @JSImport("@material-ui/icons/SwapHorizontalCircle", JSImport.Default)
  @js.native
  object SwapHorizontalCircleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SwapHorizontalCircleJS)
  
  def apply() = jsFnComponent()

}
    