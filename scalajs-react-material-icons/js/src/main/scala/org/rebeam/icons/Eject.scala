
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Eject {

  @JSImport("@material-ui/icons/Eject", JSImport.Default)
  @js.native
  object EjectJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EjectJS)
  
  def apply() = jsFnComponent()

}
    