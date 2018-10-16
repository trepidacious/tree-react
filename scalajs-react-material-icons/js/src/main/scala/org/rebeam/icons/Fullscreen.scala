
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Fullscreen {

  @JSImport("@material-ui/icons/Fullscreen", JSImport.Default)
  @js.native
  object FullscreenJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FullscreenJS)
  
  def apply() = jsFnComponent()

}
    