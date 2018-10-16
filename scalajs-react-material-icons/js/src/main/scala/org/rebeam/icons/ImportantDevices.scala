
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ImportantDevices {

  @JSImport("@material-ui/icons/ImportantDevices", JSImport.Default)
  @js.native
  object ImportantDevicesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ImportantDevicesJS)
  
  def apply() = jsFnComponent()

}
    