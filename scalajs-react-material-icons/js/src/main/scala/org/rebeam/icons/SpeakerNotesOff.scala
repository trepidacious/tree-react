
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SpeakerNotesOff {

  @JSImport("@material-ui/icons/SpeakerNotesOff", JSImport.Default)
  @js.native
  object SpeakerNotesOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SpeakerNotesOffJS)
  
  def apply() = jsFnComponent()

}
    