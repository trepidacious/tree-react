
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Motorcycle {

  @JSImport("@material-ui/icons/Motorcycle", JSImport.Default)
  @js.native
  object MotorcycleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MotorcycleJS)
  
  def apply() = jsFnComponent()

}
    