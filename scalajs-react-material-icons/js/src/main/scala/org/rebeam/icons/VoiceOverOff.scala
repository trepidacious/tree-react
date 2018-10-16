
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VoiceOverOff {

  @JSImport("@material-ui/icons/VoiceOverOff", JSImport.Default)
  @js.native
  object VoiceOverOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VoiceOverOffJS)
  
  def apply() = jsFnComponent()

}
    