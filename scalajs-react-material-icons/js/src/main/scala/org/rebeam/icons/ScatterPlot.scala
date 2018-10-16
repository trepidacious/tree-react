
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ScatterPlot {

  @JSImport("@material-ui/icons/ScatterPlot", JSImport.Default)
  @js.native
  object ScatterPlotJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ScatterPlotJS)
  
  def apply() = jsFnComponent()

}
    