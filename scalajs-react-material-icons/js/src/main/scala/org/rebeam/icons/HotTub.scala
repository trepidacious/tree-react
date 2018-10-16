
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HotTub {

  @JSImport("@material-ui/icons/HotTub", JSImport.Default)
  @js.native
  object HotTubJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HotTubJS)
  
  def apply() = jsFnComponent()

}
    