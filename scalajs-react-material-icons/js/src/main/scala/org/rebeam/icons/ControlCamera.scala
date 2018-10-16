
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ControlCamera {

  @JSImport("@material-ui/icons/ControlCamera", JSImport.Default)
  @js.native
  object ControlCameraJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ControlCameraJS)
  
  def apply() = jsFnComponent()

}
    