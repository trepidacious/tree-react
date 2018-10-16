
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CheckBoxOutlineBlank {

  @JSImport("@material-ui/icons/CheckBoxOutlineBlank", JSImport.Default)
  @js.native
  object CheckBoxOutlineBlankJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CheckBoxOutlineBlankJS)
  
  def apply() = jsFnComponent()

}
    