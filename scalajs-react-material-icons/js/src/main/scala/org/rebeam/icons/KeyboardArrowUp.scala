
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object KeyboardArrowUp {

  @JSImport("@material-ui/icons/KeyboardArrowUp", JSImport.Default)
  @js.native
  object KeyboardArrowUpJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](KeyboardArrowUpJS)
  
  def apply() = jsFnComponent()

}
    