
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ArrowDropDown {

  @JSImport("@material-ui/icons/ArrowDropDown", JSImport.Default)
  @js.native
  object ArrowDropDownJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArrowDropDownJS)
  
  def apply() = jsFnComponent()

}
    