
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalWifi4Bar {

  @JSImport("@material-ui/icons/SignalWifi4Bar", JSImport.Default)
  @js.native
  object SignalWifi4BarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalWifi4BarJS)
  
  def apply() = jsFnComponent()

}
    