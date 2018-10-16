
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Traffic {

  @JSImport("@material-ui/icons/Traffic", JSImport.Default)
  @js.native
  object TrafficJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TrafficJS)
  
  def apply() = jsFnComponent()

}
    