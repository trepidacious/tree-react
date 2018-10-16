
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalCellular3Bar {

  @JSImport("@material-ui/icons/SignalCellular3Bar", JSImport.Default)
  @js.native
  object SignalCellular3BarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalCellular3BarJS)
  
  def apply() = jsFnComponent()

}
    