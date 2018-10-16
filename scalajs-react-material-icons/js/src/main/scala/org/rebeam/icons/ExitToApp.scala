
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ExitToApp {

  @JSImport("@material-ui/icons/ExitToApp", JSImport.Default)
  @js.native
  object ExitToAppJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ExitToAppJS)
  
  def apply() = jsFnComponent()

}
    