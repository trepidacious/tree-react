
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object KeyboardReturn {

  @JSImport("@material-ui/icons/KeyboardReturn", JSImport.Default)
  @js.native
  object KeyboardReturnJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](KeyboardReturnJS)
  
  def apply() = jsFnComponent()

}
    