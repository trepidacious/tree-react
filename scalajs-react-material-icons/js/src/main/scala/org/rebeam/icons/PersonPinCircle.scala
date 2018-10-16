
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PersonPinCircle {

  @JSImport("@material-ui/icons/PersonPinCircle", JSImport.Default)
  @js.native
  object PersonPinCircleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PersonPinCircleJS)
  
  def apply() = jsFnComponent()

}
    