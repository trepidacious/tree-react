
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object KeyboardVoice {

  @JSImport("@material-ui/icons/KeyboardVoice", JSImport.Default)
  @js.native
  object KeyboardVoiceJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](KeyboardVoiceJS)
  
  def apply() = jsFnComponent()

}
    