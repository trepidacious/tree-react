
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ToggleOff {

  @JSImport("@material-ui/icons/ToggleOff", JSImport.Default)
  @js.native
  object ToggleOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ToggleOffJS)
  
  def apply() = jsFnComponent()

}
    