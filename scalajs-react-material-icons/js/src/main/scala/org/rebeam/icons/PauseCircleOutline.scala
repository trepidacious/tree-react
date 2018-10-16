
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PauseCircleOutline {

  @JSImport("@material-ui/icons/PauseCircleOutline", JSImport.Default)
  @js.native
  object PauseCircleOutlineJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PauseCircleOutlineJS)
  
  def apply() = jsFnComponent()

}
    