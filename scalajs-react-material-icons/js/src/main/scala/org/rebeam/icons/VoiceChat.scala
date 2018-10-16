
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VoiceChat {

  @JSImport("@material-ui/icons/VoiceChat", JSImport.Default)
  @js.native
  object VoiceChatJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VoiceChatJS)
  
  def apply() = jsFnComponent()

}
    