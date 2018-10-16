
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalCellular4Bar {

  @JSImport("@material-ui/icons/SignalCellular4Bar", JSImport.Default)
  @js.native
  object SignalCellular4BarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalCellular4BarJS)
  
  def apply() = jsFnComponent()

}
    