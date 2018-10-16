
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RadioButtonUnchecked {

  @JSImport("@material-ui/icons/RadioButtonUnchecked", JSImport.Default)
  @js.native
  object RadioButtonUncheckedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RadioButtonUncheckedJS)
  
  def apply() = jsFnComponent()

}
    