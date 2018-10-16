
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SurroundSound {

  @JSImport("@material-ui/icons/SurroundSound", JSImport.Default)
  @js.native
  object SurroundSoundJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SurroundSoundJS)
  
  def apply() = jsFnComponent()

}
    