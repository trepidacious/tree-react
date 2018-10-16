
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Backspace {

  @JSImport("@material-ui/icons/Backspace", JSImport.Default)
  @js.native
  object BackspaceJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BackspaceJS)
  
  def apply() = jsFnComponent()

}
    