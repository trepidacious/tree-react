
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Devices {

  @JSImport("@material-ui/icons/Devices", JSImport.Default)
  @js.native
  object DevicesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DevicesJS)
  
  def apply() = jsFnComponent()

}
    