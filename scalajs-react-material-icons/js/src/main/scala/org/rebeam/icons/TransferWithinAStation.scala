
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TransferWithinAStation {

  @JSImport("@material-ui/icons/TransferWithinAStation", JSImport.Default)
  @js.native
  object TransferWithinAStationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TransferWithinAStationJS)
  
  def apply() = jsFnComponent()

}
    