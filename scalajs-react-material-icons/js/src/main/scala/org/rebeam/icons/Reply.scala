
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Reply {

  @JSImport("@material-ui/icons/Reply", JSImport.Default)
  @js.native
  object ReplyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ReplyJS)
  
  def apply() = jsFnComponent()

}
    