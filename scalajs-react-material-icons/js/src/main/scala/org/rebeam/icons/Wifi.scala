
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Wifi {

  @JSImport("@material-ui/icons/Wifi", JSImport.Default)
  @js.native
  object WifiJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WifiJS)
  
  def apply() = jsFnComponent()

}
    