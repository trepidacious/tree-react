
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DirectionsBike {

  @JSImport("@material-ui/icons/DirectionsBike", JSImport.Default)
  @js.native
  object DirectionsBikeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DirectionsBikeJS)
  
  def apply() = jsFnComponent()

}
    