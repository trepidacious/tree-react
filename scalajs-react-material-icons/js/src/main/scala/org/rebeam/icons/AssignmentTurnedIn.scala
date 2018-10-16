
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AssignmentTurnedIn {

  @JSImport("@material-ui/icons/AssignmentTurnedIn", JSImport.Default)
  @js.native
  object AssignmentTurnedInJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AssignmentTurnedInJS)
  
  def apply() = jsFnComponent()

}
    