
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RemoveFromQueue {

  @JSImport("@material-ui/icons/RemoveFromQueue", JSImport.Default)
  @js.native
  object RemoveFromQueueJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RemoveFromQueueJS)
  
  def apply() = jsFnComponent()

}
    