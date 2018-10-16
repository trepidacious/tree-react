
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalCellular1Bar {

  @JSImport("@material-ui/icons/SignalCellular1Bar", JSImport.Default)
  @js.native
  object SignalCellular1BarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalCellular1BarJS)
  
  def apply() = jsFnComponent()

}
    