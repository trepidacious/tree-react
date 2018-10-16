
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ScreenLockRotation {

  @JSImport("@material-ui/icons/ScreenLockRotation", JSImport.Default)
  @js.native
  object ScreenLockRotationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ScreenLockRotationJS)
  
  def apply() = jsFnComponent()

}
    