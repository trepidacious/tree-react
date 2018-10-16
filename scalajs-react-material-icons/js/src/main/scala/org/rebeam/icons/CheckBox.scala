
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CheckBox {

  @JSImport("@material-ui/icons/CheckBox", JSImport.Default)
  @js.native
  object CheckBoxJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CheckBoxJS)
  
  def apply() = jsFnComponent()

}
    