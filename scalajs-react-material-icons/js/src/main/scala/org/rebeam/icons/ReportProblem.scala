
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ReportProblem {

  @JSImport("@material-ui/icons/ReportProblem", JSImport.Default)
  @js.native
  object ReportProblemJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ReportProblemJS)
  
  def apply() = jsFnComponent()

}
    