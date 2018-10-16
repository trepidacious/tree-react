
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object BugReport {

  @JSImport("@material-ui/icons/BugReport", JSImport.Default)
  @js.native
  object BugReportJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BugReportJS)
  
  def apply() = jsFnComponent()

}
    