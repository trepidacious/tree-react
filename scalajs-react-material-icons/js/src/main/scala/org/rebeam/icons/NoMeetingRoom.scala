
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NoMeetingRoom {

  @JSImport("@material-ui/icons/NoMeetingRoom", JSImport.Default)
  @js.native
  object NoMeetingRoomJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NoMeetingRoomJS)
  
  def apply() = jsFnComponent()

}
    