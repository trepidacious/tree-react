
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DeviceUnknown {

  @JSImport("@material-ui/icons/DeviceUnknown", JSImport.Default)
  @js.native
  object DeviceUnknownJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DeviceUnknownJS)
  
  def apply() = jsFnComponent()

}
    