
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Announcement {

  @JSImport("@material-ui/icons/Announcement", JSImport.Default)
  @js.native
  object AnnouncementJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AnnouncementJS)
  
  def apply() = jsFnComponent()

}
    