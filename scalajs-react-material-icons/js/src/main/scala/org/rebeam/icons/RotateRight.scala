
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RotateRight {

  @JSImport("@material-ui/icons/RotateRight", JSImport.Default)
  @js.native
  object RotateRightJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RotateRightJS)
  
  def apply() = jsFnComponent()

}
    