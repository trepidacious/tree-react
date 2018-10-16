
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VerticalSplit {

  @JSImport("@material-ui/icons/VerticalSplit", JSImport.Default)
  @js.native
  object VerticalSplitJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VerticalSplitJS)
  
  def apply() = jsFnComponent()

}
    