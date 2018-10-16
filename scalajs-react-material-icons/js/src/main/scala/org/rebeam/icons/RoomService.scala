
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RoomService {

  @JSImport("@material-ui/icons/RoomService", JSImport.Default)
  @js.native
  object RoomServiceJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RoomServiceJS)
  
  def apply() = jsFnComponent()

}
    