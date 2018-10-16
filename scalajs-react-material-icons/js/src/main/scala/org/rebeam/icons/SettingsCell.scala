
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsCell {

  @JSImport("@material-ui/icons/SettingsCell", JSImport.Default)
  @js.native
  object SettingsCellJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsCellJS)
  
  def apply() = jsFnComponent()

}
    