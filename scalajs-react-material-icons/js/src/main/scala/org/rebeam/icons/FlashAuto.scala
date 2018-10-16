
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FlashAuto {

  @JSImport("@material-ui/icons/FlashAuto", JSImport.Default)
  @js.native
  object FlashAutoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FlashAutoJS)
  
  def apply() = jsFnComponent()

}
    