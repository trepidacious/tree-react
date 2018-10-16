
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object KeyboardArrowDown {

  @JSImport("@material-ui/icons/KeyboardArrowDown", JSImport.Default)
  @js.native
  object KeyboardArrowDownJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](KeyboardArrowDownJS)
  
  def apply() = jsFnComponent()

}
    