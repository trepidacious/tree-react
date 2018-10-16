
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SignalWifi0Bar {

  @JSImport("@material-ui/icons/SignalWifi0Bar", JSImport.Default)
  @js.native
  object SignalWifi0BarJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SignalWifi0BarJS)
  
  def apply() = jsFnComponent()

}
    