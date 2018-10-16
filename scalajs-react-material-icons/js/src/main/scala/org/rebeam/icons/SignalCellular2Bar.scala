
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalCellular2Bar {

  @JSImport("@material-ui/icons/SignalCellular2Bar", JSImport.Default)
  @js.native
  object SignalCellular2BarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalCellular2BarJS)
  
  def apply() = jsFnComponent()

}
    