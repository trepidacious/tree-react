
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AssignmentReturn {

  @JSImport("@material-ui/icons/AssignmentReturn", JSImport.Default)
  @js.native
  object AssignmentReturnJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AssignmentReturnJS)
  
  def apply() = jsFnComponent()

}
    