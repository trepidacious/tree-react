
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LowPriority {

  @JSImport("@material-ui/icons/LowPriority", JSImport.Default)
  @js.native
  object LowPriorityJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LowPriorityJS)
  
  def apply() = jsFnComponent()

}
    