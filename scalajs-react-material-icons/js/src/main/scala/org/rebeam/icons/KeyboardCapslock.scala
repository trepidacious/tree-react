
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object KeyboardCapslock {

  @JSImport("@material-ui/icons/KeyboardCapslock", JSImport.Default)
  @js.native
  object KeyboardCapslockJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](KeyboardCapslockJS)
  
  def apply() = jsFnComponent()

}
    