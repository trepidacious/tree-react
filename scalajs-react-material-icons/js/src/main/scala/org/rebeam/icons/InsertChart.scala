
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object InsertChart {

  @JSImport("@material-ui/icons/InsertChart", JSImport.Default)
  @js.native
  object InsertChartJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](InsertChartJS)
  
  def apply() = jsFnComponent()

}
    