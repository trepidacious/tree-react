
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Speaker {

  @JSImport("@material-ui/icons/Speaker", JSImport.Default)
  @js.native
  object SpeakerJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SpeakerJS)
  
  def apply() = jsFnComponent()

}
    