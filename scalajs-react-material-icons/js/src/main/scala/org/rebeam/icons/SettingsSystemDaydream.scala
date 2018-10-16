
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsSystemDaydream {

  @JSImport("@material-ui/icons/SettingsSystemDaydream", JSImport.Default)
  @js.native
  object SettingsSystemDaydreamJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsSystemDaydreamJS)
  
  def apply() = jsFnComponent()

}
    