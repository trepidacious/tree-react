
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Assistant {

  @JSImport("@material-ui/icons/Assistant", JSImport.Default)
  @js.native
  object AssistantJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AssistantJS)
  
  def apply() = jsFnComponent()

}
    