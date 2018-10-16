
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DragIndicator {

  @JSImport("@material-ui/icons/DragIndicator", JSImport.Default)
  @js.native
  object DragIndicatorJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DragIndicatorJS)
  
  def apply() = jsFnComponent()

}
    