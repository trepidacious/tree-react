
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Atm {

  @JSImport("@material-ui/icons/Atm", JSImport.Default)
  @js.native
  object AtmJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AtmJS)
  
  def apply() = jsFnComponent()

}
    