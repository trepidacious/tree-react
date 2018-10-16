
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalWifi1Bar {

  @JSImport("@material-ui/icons/SignalWifi1Bar", JSImport.Default)
  @js.native
  object SignalWifi1BarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalWifi1BarJS)
  
  def apply() = jsFnComponent()

}
    