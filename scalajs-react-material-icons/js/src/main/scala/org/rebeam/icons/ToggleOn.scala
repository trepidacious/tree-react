
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ToggleOn {

  @JSImport("@material-ui/icons/ToggleOn", JSImport.Default)
  @js.native
  object ToggleOnJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ToggleOnJS)
  
  def apply() = jsFnComponent()

}
    