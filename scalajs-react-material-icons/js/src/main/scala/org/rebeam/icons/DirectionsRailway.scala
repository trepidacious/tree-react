
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DirectionsRailway {

  @JSImport("@material-ui/icons/DirectionsRailway", JSImport.Default)
  @js.native
  object DirectionsRailwayJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DirectionsRailwayJS)
  
  def apply() = jsFnComponent()

}
    