
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VpnKey {

  @JSImport("@material-ui/icons/VpnKey", JSImport.Default)
  @js.native
  object VpnKeyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VpnKeyJS)
  
  def apply() = jsFnComponent()

}
    