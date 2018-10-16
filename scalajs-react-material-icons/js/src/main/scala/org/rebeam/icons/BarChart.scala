
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BarChart {

  @JSImport("@material-ui/icons/BarChart", JSImport.Default)
  @js.native
  object BarChartJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BarChartJS)
  
  def apply() = jsFnComponent()

}
    