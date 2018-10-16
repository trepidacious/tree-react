
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalWifi2Bar {

  @JSImport("@material-ui/icons/SignalWifi2Bar", JSImport.Default)
  @js.native
  object SignalWifi2BarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalWifi2BarJS)
  
  def apply() = jsFnComponent()

}
    