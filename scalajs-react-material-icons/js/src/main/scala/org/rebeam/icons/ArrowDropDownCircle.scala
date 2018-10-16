
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ArrowDropDownCircle {

  @JSImport("@material-ui/icons/ArrowDropDownCircle", JSImport.Default)
  @js.native
  object ArrowDropDownCircleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArrowDropDownCircleJS)
  
  def apply() = jsFnComponent()

}
    