
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CloudCircle {

  @JSImport("@material-ui/icons/CloudCircle", JSImport.Default)
  @js.native
  object CloudCircleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CloudCircleJS)
  
  def apply() = jsFnComponent()

}
    