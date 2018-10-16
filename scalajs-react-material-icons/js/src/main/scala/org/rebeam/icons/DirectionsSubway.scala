
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DirectionsSubway {

  @JSImport("@material-ui/icons/DirectionsSubway", JSImport.Default)
  @js.native
  object DirectionsSubwayJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DirectionsSubwayJS)
  
  def apply() = jsFnComponent()

}
    