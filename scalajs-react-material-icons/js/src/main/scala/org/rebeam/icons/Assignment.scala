
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Assignment {

  @JSImport("@material-ui/icons/Assignment", JSImport.Default)
  @js.native
  object AssignmentJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AssignmentJS)
  
  def apply() = jsFnComponent()

}
    