
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalWifi3Bar {

  @JSImport("@material-ui/icons/SignalWifi3Bar", JSImport.Default)
  @js.native
  object SignalWifi3BarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalWifi3BarJS)
  
  def apply() = jsFnComponent()

}
    