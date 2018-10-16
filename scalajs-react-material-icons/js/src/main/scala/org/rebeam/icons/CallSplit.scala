
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CallSplit {

  @JSImport("@material-ui/icons/CallSplit", JSImport.Default)
  @js.native
  object CallSplitJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CallSplitJS)
  
  def apply() = jsFnComponent()

}
    