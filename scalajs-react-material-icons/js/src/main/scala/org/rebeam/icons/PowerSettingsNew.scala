
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PowerSettingsNew {

  @JSImport("@material-ui/icons/PowerSettingsNew", JSImport.Default)
  @js.native
  object PowerSettingsNewJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PowerSettingsNewJS)
  
  def apply() = jsFnComponent()

}
    