
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object InsertInvitation {

  @JSImport("@material-ui/icons/InsertInvitation", JSImport.Default)
  @js.native
  object InsertInvitationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](InsertInvitationJS)
  
  def apply() = jsFnComponent()

}
    