
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ChatBubbleOutline {

  @JSImport("@material-ui/icons/ChatBubbleOutline", JSImport.Default)
  @js.native
  object ChatBubbleOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ChatBubbleOutlineJS)
  
  def apply() = jsFnComponent()

}
    