
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Equalizer {

  @JSImport("@material-ui/icons/Equalizer", JSImport.Default)
  @js.native
  object EqualizerJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EqualizerJS)
  
  def apply() = jsFnComponent()

}
    