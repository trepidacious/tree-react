
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsInputComposite {

  @JSImport("@material-ui/icons/SettingsInputComposite", JSImport.Default)
  @js.native
  object SettingsInputCompositeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsInputCompositeJS)
  
  def apply() = jsFnComponent()

}
    