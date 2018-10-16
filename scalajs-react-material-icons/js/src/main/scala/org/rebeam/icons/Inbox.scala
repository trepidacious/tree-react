
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Inbox {

  @JSImport("@material-ui/icons/Inbox", JSImport.Default)
  @js.native
  object InboxJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](InboxJS)
  
  def apply() = jsFnComponent()

}
    