
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DeleteSweep {

  @JSImport("@material-ui/icons/DeleteSweep", JSImport.Default)
  @js.native
  object DeleteSweepJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DeleteSweepJS)
  
  def apply() = jsFnComponent()

}
    