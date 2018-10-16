
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PortableWifiOff {

  @JSImport("@material-ui/icons/PortableWifiOff", JSImport.Default)
  @js.native
  object PortableWifiOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PortableWifiOffJS)
  
  def apply() = jsFnComponent()

}
    