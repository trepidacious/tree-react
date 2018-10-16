
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocationDisabled {

  @JSImport("@material-ui/icons/LocationDisabled", JSImport.Default)
  @js.native
  object LocationDisabledJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocationDisabledJS)
  
  def apply() = jsFnComponent()

}
    