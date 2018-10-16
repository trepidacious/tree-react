
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TableChart {

  @JSImport("@material-ui/icons/TableChart", JSImport.Default)
  @js.native
  object TableChartJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TableChartJS)
  
  def apply() = jsFnComponent()

}
    