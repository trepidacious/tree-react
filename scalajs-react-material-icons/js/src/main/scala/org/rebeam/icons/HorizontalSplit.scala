
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HorizontalSplit {

  @JSImport("@material-ui/icons/HorizontalSplit", JSImport.Default)
  @js.native
  object HorizontalSplitJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HorizontalSplitJS)
  
  def apply() = jsFnComponent()

}
    