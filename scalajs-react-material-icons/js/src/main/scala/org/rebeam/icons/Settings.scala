
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Settings {

  @JSImport("@material-ui/icons/Settings", JSImport.Default)
  @js.native
  object SettingsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsJS)
  
  def apply() = jsFnComponent()

}
    