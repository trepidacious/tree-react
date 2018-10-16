
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TabUnselected {

  @JSImport("@material-ui/icons/TabUnselected", JSImport.Default)
  @js.native
  object TabUnselectedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TabUnselectedJS)
  
  def apply() = jsFnComponent()

}
    