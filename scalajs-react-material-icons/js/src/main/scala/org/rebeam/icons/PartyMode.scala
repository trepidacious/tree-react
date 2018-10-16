
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PartyMode {

  @JSImport("@material-ui/icons/PartyMode", JSImport.Default)
  @js.native
  object PartyModeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PartyModeJS)
  
  def apply() = jsFnComponent()

}
    