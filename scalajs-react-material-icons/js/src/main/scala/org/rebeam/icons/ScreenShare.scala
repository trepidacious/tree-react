
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ScreenShare {

  @JSImport("@material-ui/icons/ScreenShare", JSImport.Default)
  @js.native
  object ScreenShareJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ScreenShareJS)
  
  def apply() = jsFnComponent()

}
    