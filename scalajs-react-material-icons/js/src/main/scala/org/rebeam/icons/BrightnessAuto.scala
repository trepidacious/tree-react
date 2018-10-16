
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BrightnessAuto {

  @JSImport("@material-ui/icons/BrightnessAuto", JSImport.Default)
  @js.native
  object BrightnessAutoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BrightnessAutoJS)
  
  def apply() = jsFnComponent()

}
    