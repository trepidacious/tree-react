
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhonePaused {

  @JSImport("@material-ui/icons/PhonePaused", JSImport.Default)
  @js.native
  object PhonePausedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhonePausedJS)
  
  def apply() = jsFnComponent()

}
    