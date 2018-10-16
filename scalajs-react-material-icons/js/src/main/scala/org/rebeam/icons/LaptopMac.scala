
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LaptopMac {

  @JSImport("@material-ui/icons/LaptopMac", JSImport.Default)
  @js.native
  object LaptopMacJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LaptopMacJS)
  
  def apply() = jsFnComponent()

}
    