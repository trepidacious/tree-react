
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Adjust {

  @JSImport("@material-ui/icons/Adjust", JSImport.Default)
  @js.native
  object AdjustJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AdjustJS)
  
  def apply() = jsFnComponent()

}
    