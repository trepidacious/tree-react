
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsInputHdmi {

  @JSImport("@material-ui/icons/SettingsInputHdmi", JSImport.Default)
  @js.native
  object SettingsInputHdmiJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsInputHdmiJS)
  
  def apply() = jsFnComponent()

}
    