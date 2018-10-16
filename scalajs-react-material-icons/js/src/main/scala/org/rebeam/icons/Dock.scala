
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Dock {

  @JSImport("@material-ui/icons/Dock", JSImport.Default)
  @js.native
  object DockJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DockJS)
  
  def apply() = jsFnComponent()

}
    