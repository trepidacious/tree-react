
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalCellularNull {

  @JSImport("@material-ui/icons/SignalCellularNull", JSImport.Default)
  @js.native
  object SignalCellularNullJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalCellularNullJS)
  
  def apply() = jsFnComponent()

}
    