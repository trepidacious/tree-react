
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Vibration {

  @JSImport("@material-ui/icons/Vibration", JSImport.Default)
  @js.native
  object VibrationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VibrationJS)
  
  def apply() = jsFnComponent()

}
    