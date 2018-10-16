
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object KeyboardHide {

  @JSImport("@material-ui/icons/KeyboardHide", JSImport.Default)
  @js.native
  object KeyboardHideJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](KeyboardHideJS)
  
  def apply() = jsFnComponent()

}
    