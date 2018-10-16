
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object KeyboardTab {

  @JSImport("@material-ui/icons/KeyboardTab", JSImport.Default)
  @js.native
  object KeyboardTabJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](KeyboardTabJS)
  
  def apply() = jsFnComponent()

}
    