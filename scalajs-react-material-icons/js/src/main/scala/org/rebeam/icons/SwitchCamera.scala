
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SwitchCamera {

  @JSImport("@material-ui/icons/SwitchCamera", JSImport.Default)
  @js.native
  object SwitchCameraJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SwitchCameraJS)
  
  def apply() = jsFnComponent()

}
    