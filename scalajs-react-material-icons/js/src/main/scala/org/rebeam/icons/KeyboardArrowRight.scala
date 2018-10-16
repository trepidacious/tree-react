
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object KeyboardArrowRight {

  @JSImport("@material-ui/icons/KeyboardArrowRight", JSImport.Default)
  @js.native
  object KeyboardArrowRightJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](KeyboardArrowRightJS)
  
  def apply() = jsFnComponent()

}
    