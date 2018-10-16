
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object EventBusy {

  @JSImport("@material-ui/icons/EventBusy", JSImport.Default)
  @js.native
  object EventBusyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EventBusyJS)
  
  def apply() = jsFnComponent()

}
    