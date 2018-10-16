
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalCellularOff {

  @JSImport("@material-ui/icons/SignalCellularOff", JSImport.Default)
  @js.native
  object SignalCellularOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalCellularOffJS)
  
  def apply() = jsFnComponent()

}
    