
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DirectionsTransit {

  @JSImport("@material-ui/icons/DirectionsTransit", JSImport.Default)
  @js.native
  object DirectionsTransitJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DirectionsTransitJS)
  
  def apply() = jsFnComponent()

}
    