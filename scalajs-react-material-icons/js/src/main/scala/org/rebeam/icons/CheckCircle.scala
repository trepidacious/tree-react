
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CheckCircle {

  @JSImport("@material-ui/icons/CheckCircle", JSImport.Default)
  @js.native
  object CheckCircleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CheckCircleJS)
  
  def apply() = jsFnComponent()

}
    