
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DirectionsBus {

  @JSImport("@material-ui/icons/DirectionsBus", JSImport.Default)
  @js.native
  object DirectionsBusJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DirectionsBusJS)
  
  def apply() = jsFnComponent()

}
    