
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LineWeight {

  @JSImport("@material-ui/icons/LineWeight", JSImport.Default)
  @js.native
  object LineWeightJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LineWeightJS)
  
  def apply() = jsFnComponent()

}
    