
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BrightnessHigh {

  @JSImport("@material-ui/icons/BrightnessHigh", JSImport.Default)
  @js.native
  object BrightnessHighJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BrightnessHighJS)
  
  def apply() = jsFnComponent()

}
    