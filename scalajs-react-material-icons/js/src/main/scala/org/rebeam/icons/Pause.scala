
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Pause {

  @JSImport("@material-ui/icons/Pause", JSImport.Default)
  @js.native
  object PauseJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PauseJS)
  
  def apply() = jsFnComponent()

}
    