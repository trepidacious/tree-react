
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VerticalAlignCenter {

  @JSImport("@material-ui/icons/VerticalAlignCenter", JSImport.Default)
  @js.native
  object VerticalAlignCenterJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VerticalAlignCenterJS)
  
  def apply() = jsFnComponent()

}
    