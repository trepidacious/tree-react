
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SpeakerNotes {

  @JSImport("@material-ui/icons/SpeakerNotes", JSImport.Default)
  @js.native
  object SpeakerNotesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SpeakerNotesJS)
  
  def apply() = jsFnComponent()

}
    