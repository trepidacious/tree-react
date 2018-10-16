
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FullscreenExit {

  @JSImport("@material-ui/icons/FullscreenExit", JSImport.Default)
  @js.native
  object FullscreenExitJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FullscreenExitJS)
  
  def apply() = jsFnComponent()

}
    