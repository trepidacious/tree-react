
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsPhone {

  @JSImport("@material-ui/icons/SettingsPhone", JSImport.Default)
  @js.native
  object SettingsPhoneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsPhoneJS)
  
  def apply() = jsFnComponent()

}
    