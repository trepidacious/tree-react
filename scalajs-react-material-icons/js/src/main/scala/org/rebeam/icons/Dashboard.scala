
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Dashboard {

  @JSImport("@material-ui/icons/Dashboard", JSImport.Default)
  @js.native
  object DashboardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DashboardJS)
  
  def apply() = jsFnComponent()

}
    