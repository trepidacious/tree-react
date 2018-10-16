
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DirectionsWalk {

  @JSImport("@material-ui/icons/DirectionsWalk", JSImport.Default)
  @js.native
  object DirectionsWalkJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DirectionsWalkJS)
  
  def apply() = jsFnComponent()

}
    