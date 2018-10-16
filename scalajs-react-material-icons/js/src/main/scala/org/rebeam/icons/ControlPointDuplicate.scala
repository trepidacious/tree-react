
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ControlPointDuplicate {

  @JSImport("@material-ui/icons/ControlPointDuplicate", JSImport.Default)
  @js.native
  object ControlPointDuplicateJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ControlPointDuplicateJS)
  
  def apply() = jsFnComponent()

}
    