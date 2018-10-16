
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PersonAddDisabled {

  @JSImport("@material-ui/icons/PersonAddDisabled", JSImport.Default)
  @js.native
  object PersonAddDisabledJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PersonAddDisabledJS)
  
  def apply() = jsFnComponent()

}
    