
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AssignmentInd {

  @JSImport("@material-ui/icons/AssignmentInd", JSImport.Default)
  @js.native
  object AssignmentIndJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AssignmentIndJS)
  
  def apply() = jsFnComponent()

}
    