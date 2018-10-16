
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ChatBubble {

  @JSImport("@material-ui/icons/ChatBubble", JSImport.Default)
  @js.native
  object ChatBubbleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ChatBubbleJS)
  
  def apply() = jsFnComponent()

}
    