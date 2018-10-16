
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BubbleChart {

  @JSImport("@material-ui/icons/BubbleChart", JSImport.Default)
  @js.native
  object BubbleChartJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BubbleChartJS)
  
  def apply() = jsFnComponent()

}
    