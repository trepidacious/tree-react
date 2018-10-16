
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AssignmentLate {

  @JSImport("@material-ui/icons/AssignmentLate", JSImport.Default)
  @js.native
  object AssignmentLateJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AssignmentLateJS)
  
  def apply() = jsFnComponent()

}
    