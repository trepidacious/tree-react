
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CompassCalibration {

  @JSImport("@material-ui/icons/CompassCalibration", JSImport.Default)
  @js.native
  object CompassCalibrationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CompassCalibrationJS)
  
  def apply() = jsFnComponent()

}
    