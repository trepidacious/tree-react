
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LaptopWindows {

  @JSImport("@material-ui/icons/LaptopWindows", JSImport.Default)
  @js.native
  object LaptopWindowsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LaptopWindowsJS)
  
  def apply() = jsFnComponent()

}
    