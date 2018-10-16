
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Queue {

  @JSImport("@material-ui/icons/Queue", JSImport.Default)
  @js.native
  object QueueJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](QueueJS)
  
  def apply() = jsFnComponent()

}
    