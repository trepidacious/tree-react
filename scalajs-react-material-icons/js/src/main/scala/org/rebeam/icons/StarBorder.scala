
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object StarBorder {

  @JSImport("@material-ui/icons/StarBorder", JSImport.Default)
  @js.native
  object StarBorderJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StarBorderJS)
  
  def apply() = jsFnComponent()

}
    