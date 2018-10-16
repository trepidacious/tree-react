
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Room {

  @JSImport("@material-ui/icons/Room", JSImport.Default)
  @js.native
  object RoomJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RoomJS)
  
  def apply() = jsFnComponent()

}
    