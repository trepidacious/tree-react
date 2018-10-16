
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object IndeterminateCheckBox {

  @JSImport("@material-ui/icons/IndeterminateCheckBox", JSImport.Default)
  @js.native
  object IndeterminateCheckBoxJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](IndeterminateCheckBoxJS)
  
  def apply() = jsFnComponent()

}
    