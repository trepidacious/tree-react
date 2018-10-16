
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Dehaze {

  @JSImport("@material-ui/icons/Dehaze", JSImport.Default)
  @js.native
  object DehazeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DehazeJS)
  
  def apply() = jsFnComponent()

}
    