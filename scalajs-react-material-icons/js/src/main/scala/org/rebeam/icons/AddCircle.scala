
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AddCircle {

  @JSImport("@material-ui/icons/AddCircle", JSImport.Default)
  @js.native
  object AddCircleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddCircleJS)
  
  def apply() = jsFnComponent()

}
    