
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Loop {

  @JSImport("@material-ui/icons/Loop", JSImport.Default)
  @js.native
  object LoopJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LoopJS)
  
  def apply() = jsFnComponent()

}
    