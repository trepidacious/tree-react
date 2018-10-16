
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PieChart {

  @JSImport("@material-ui/icons/PieChart", JSImport.Default)
  @js.native
  object PieChartJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PieChartJS)
  
  def apply() = jsFnComponent()

}
    