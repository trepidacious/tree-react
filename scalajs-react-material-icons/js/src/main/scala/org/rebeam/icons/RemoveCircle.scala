
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RemoveCircle {

  @JSImport("@material-ui/icons/RemoveCircle", JSImport.Default)
  @js.native
  object RemoveCircleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RemoveCircleJS)
  
  def apply() = jsFnComponent()

}
    