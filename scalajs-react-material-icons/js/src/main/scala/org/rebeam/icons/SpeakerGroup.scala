
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SpeakerGroup {

  @JSImport("@material-ui/icons/SpeakerGroup", JSImport.Default)
  @js.native
  object SpeakerGroupJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SpeakerGroupJS)
  
  def apply() = jsFnComponent()

}
    