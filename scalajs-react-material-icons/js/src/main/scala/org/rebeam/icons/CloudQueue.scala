
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CloudQueue {

  @JSImport("@material-ui/icons/CloudQueue", JSImport.Default)
  @js.native
  object CloudQueueJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CloudQueueJS)
  
  def apply() = jsFnComponent()

}
    