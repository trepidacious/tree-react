
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsEthernet {

  @JSImport("@material-ui/icons/SettingsEthernet", JSImport.Default)
  @js.native
  object SettingsEthernetJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsEthernetJS)
  
  def apply() = jsFnComponent()

}
    