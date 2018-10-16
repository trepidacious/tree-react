
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MultilineChart {

  @JSImport("@material-ui/icons/MultilineChart", JSImport.Default)
  @js.native
  object MultilineChartJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MultilineChartJS)
  
  def apply() = jsFnComponent()

}
    