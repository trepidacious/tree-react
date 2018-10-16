
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Keyboard {

  @JSImport("@material-ui/icons/Keyboard", JSImport.Default)
  @js.native
  object KeyboardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](KeyboardJS)
  
  def apply() = jsFnComponent()

}
    