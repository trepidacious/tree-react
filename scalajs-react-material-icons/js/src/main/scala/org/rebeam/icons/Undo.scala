
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Undo {

  @JSImport("@material-ui/icons/Undo", JSImport.Default)
  @js.native
  object UndoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](UndoJS)
  
  def apply() = jsFnComponent()

}
    