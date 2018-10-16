
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsOverscan {

  @JSImport("@material-ui/icons/SettingsOverscan", JSImport.Default)
  @js.native
  object SettingsOverscanJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsOverscanJS)
  
  def apply() = jsFnComponent()

}
    