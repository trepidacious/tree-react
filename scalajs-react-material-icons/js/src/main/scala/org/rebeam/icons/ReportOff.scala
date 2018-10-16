
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ReportOff {

  @JSImport("@material-ui/icons/ReportOff", JSImport.Default)
  @js.native
  object ReportOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ReportOffJS)
  
  def apply() = jsFnComponent()

}
    