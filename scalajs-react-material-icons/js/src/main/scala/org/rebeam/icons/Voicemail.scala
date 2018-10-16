
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Voicemail {

  @JSImport("@material-ui/icons/Voicemail", JSImport.Default)
  @js.native
  object VoicemailJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VoicemailJS)
  
  def apply() = jsFnComponent()

}
    