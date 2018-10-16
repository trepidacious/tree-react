
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ShowChart {

  @JSImport("@material-ui/icons/ShowChart", JSImport.Default)
  @js.native
  object ShowChartJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ShowChartJS)
  
  def apply() = jsFnComponent()

}
    