
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MoveToInbox {

  @JSImport("@material-ui/icons/MoveToInbox", JSImport.Default)
  @js.native
  object MoveToInboxJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MoveToInboxJS)
  
  def apply() = jsFnComponent()

}
    