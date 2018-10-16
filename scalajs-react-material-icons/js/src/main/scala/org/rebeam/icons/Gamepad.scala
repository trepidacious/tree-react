
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Gamepad {

  @JSImport("@material-ui/icons/Gamepad", JSImport.Default)
  @js.native
  object GamepadJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GamepadJS)
  
  def apply() = jsFnComponent()

}
    