
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AssignmentReturned {

  @JSImport("@material-ui/icons/AssignmentReturned", JSImport.Default)
  @js.native
  object AssignmentReturnedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AssignmentReturnedJS)
  
  def apply() = jsFnComponent()

}
    