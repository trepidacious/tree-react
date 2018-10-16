
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CastConnected {

  @JSImport("@material-ui/icons/CastConnected", JSImport.Default)
  @js.native
  object CastConnectedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CastConnectedJS)
  
  def apply() = jsFnComponent()

}
    