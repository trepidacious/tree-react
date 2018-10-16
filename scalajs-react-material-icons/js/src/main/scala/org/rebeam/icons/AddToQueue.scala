
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AddToQueue {

  @JSImport("@material-ui/icons/AddToQueue", JSImport.Default)
  @js.native
  object AddToQueueJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddToQueueJS)
  
  def apply() = jsFnComponent()

}
    