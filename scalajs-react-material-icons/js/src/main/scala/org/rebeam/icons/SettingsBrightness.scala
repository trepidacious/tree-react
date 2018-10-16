
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsBrightness {

  @JSImport("@material-ui/icons/SettingsBrightness", JSImport.Default)
  @js.native
  object SettingsBrightnessJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsBrightnessJS)
  
  def apply() = jsFnComponent()

}
    