
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Flip {

  @JSImport("@material-ui/icons/Flip", JSImport.Default)
  @js.native
  object FlipJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FlipJS)
  
  def apply() = jsFnComponent()

}
    