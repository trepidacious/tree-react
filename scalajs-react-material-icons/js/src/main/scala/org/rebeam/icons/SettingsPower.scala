
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsPower {

  @JSImport("@material-ui/icons/SettingsPower", JSImport.Default)
  @js.native
  object SettingsPowerJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsPowerJS)
  
  def apply() = jsFnComponent()

}
    