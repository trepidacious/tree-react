
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FilterTiltShift {

  @JSImport("@material-ui/icons/FilterTiltShift", JSImport.Default)
  @js.native
  object FilterTiltShiftJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FilterTiltShiftJS)
  
  def apply() = jsFnComponent()

}
    