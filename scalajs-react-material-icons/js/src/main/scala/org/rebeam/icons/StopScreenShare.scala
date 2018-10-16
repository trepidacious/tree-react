
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object StopScreenShare {

  @JSImport("@material-ui/icons/StopScreenShare", JSImport.Default)
  @js.native
  object StopScreenShareJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StopScreenShareJS)
  
  def apply() = jsFnComponent()

}
    