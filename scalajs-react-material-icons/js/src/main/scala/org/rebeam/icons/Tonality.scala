
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Tonality {

  @JSImport("@material-ui/icons/Tonality", JSImport.Default)
  @js.native
  object TonalityJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TonalityJS)
  
  def apply() = jsFnComponent()

}
    