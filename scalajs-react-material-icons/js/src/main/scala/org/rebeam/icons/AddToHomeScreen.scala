
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AddToHomeScreen {

  @JSImport("@material-ui/icons/AddToHomeScreen", JSImport.Default)
  @js.native
  object AddToHomeScreenJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddToHomeScreenJS)
  
  def apply() = jsFnComponent()

}
    