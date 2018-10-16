
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MeetingRoom {

  @JSImport("@material-ui/icons/MeetingRoom", JSImport.Default)
  @js.native
  object MeetingRoomJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MeetingRoomJS)
  
  def apply() = jsFnComponent()

}
    