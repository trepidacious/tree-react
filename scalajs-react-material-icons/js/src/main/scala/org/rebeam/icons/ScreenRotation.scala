
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ScreenRotation {

  @JSImport("@material-ui/icons/ScreenRotation", JSImport.Default)
  @js.native
  object ScreenRotationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ScreenRotationJS)
  
  def apply() = jsFnComponent()

}
    