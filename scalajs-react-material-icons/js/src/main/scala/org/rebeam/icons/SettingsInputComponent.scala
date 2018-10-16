
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsInputComponent {

  @JSImport("@material-ui/icons/SettingsInputComponent", JSImport.Default)
  @js.native
  object SettingsInputComponentJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsInputComponentJS)
  
  def apply() = jsFnComponent()

}
    