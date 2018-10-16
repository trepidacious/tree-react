
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RadioButtonChecked {

  @JSImport("@material-ui/icons/RadioButtonChecked", JSImport.Default)
  @js.native
  object RadioButtonCheckedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RadioButtonCheckedJS)
  
  def apply() = jsFnComponent()

}
    