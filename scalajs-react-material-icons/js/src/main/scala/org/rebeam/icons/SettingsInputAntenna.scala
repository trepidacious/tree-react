
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsInputAntenna {

  @JSImport("@material-ui/icons/SettingsInputAntenna", JSImport.Default)
  @js.native
  object SettingsInputAntennaJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsInputAntennaJS)
  
  def apply() = jsFnComponent()

}
    