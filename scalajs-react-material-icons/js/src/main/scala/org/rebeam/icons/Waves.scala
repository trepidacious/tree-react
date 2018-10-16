
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Waves {

  @JSImport("@material-ui/icons/Waves", JSImport.Default)
  @js.native
  object WavesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WavesJS)
  
  def apply() = jsFnComponent()

}
    