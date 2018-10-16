
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SpeakerPhone {

  @JSImport("@material-ui/icons/SpeakerPhone", JSImport.Default)
  @js.native
  object SpeakerPhoneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SpeakerPhoneJS)
  
  def apply() = jsFnComponent()

}
    