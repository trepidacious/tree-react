
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Report {

  @JSImport("@material-ui/icons/Report", JSImport.Default)
  @js.native
  object ReportJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ReportJS)
  
  def apply() = jsFnComponent()

}
    