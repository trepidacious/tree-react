
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsApplications {

  @JSImport("@material-ui/icons/SettingsApplications", JSImport.Default)
  @js.native
  object SettingsApplicationsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsApplicationsJS)
  
  def apply() = jsFnComponent()

}
    