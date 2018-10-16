
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PriorityHigh {

  @JSImport("@material-ui/icons/PriorityHigh", JSImport.Default)
  @js.native
  object PriorityHighJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PriorityHighJS)
  
  def apply() = jsFnComponent()

}
    