
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DragHandle {

  @JSImport("@material-ui/icons/DragHandle", JSImport.Default)
  @js.native
  object DragHandleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DragHandleJS)
  
  def apply() = jsFnComponent()

}
    