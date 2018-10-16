
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Navigation {

  @JSImport("@material-ui/icons/Navigation", JSImport.Default)
  @js.native
  object NavigationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NavigationJS)
  
  def apply() = jsFnComponent()

}
    