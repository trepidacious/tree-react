
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BrightnessLow {

  @JSImport("@material-ui/icons/BrightnessLow", JSImport.Default)
  @js.native
  object BrightnessLowJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BrightnessLowJS)
  
  def apply() = jsFnComponent()

}
    