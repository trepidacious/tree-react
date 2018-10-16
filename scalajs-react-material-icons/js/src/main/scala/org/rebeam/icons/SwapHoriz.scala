
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SwapHoriz {

  @JSImport("@material-ui/icons/SwapHoriz", JSImport.Default)
  @js.native
  object SwapHorizJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SwapHorizJS)
  
  def apply() = jsFnComponent()

}
    