
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SettingsVoice {

  @JSImport("@material-ui/icons/SettingsVoice", JSImport.Default)
  @js.native
  object SettingsVoiceJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SettingsVoiceJS)
  
  def apply() = jsFnComponent()

}
    