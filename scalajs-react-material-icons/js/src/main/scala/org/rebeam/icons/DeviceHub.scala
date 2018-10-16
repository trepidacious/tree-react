
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DeviceHub {

  @JSImport("@material-ui/icons/DeviceHub", JSImport.Default)
  @js.native
  object DeviceHubJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DeviceHubJS)
  
  def apply() = jsFnComponent()

}
    