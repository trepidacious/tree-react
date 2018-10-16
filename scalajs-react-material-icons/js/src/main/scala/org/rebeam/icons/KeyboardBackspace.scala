
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object KeyboardBackspace {

  @JSImport("@material-ui/icons/KeyboardBackspace", JSImport.Default)
  @js.native
  object KeyboardBackspaceJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](KeyboardBackspaceJS)
  
  def apply() = jsFnComponent()

}
    