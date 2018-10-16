
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RecordVoiceOver {

  @JSImport("@material-ui/icons/RecordVoiceOver", JSImport.Default)
  @js.native
  object RecordVoiceOverJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RecordVoiceOverJS)
  
  def apply() = jsFnComponent()

}
    