
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FitnessCenter {

  @JSImport("@material-ui/icons/FitnessCenter", JSImport.Default)
  @js.native
  object FitnessCenterJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FitnessCenterJS)
  
  def apply() = jsFnComponent()

}
    