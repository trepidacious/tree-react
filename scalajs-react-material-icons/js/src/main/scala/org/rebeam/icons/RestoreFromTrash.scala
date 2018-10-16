
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RestoreFromTrash {

  @JSImport("@material-ui/icons/RestoreFromTrash", JSImport.Default)
  @js.native
  object RestoreFromTrashJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RestoreFromTrashJS)
  
  def apply() = jsFnComponent()

}
    