
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DesktopMac {

  @JSImport("@material-ui/icons/DesktopMac", JSImport.Default)
  @js.native
  object DesktopMacJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DesktopMacJS)
  
  def apply() = jsFnComponent()

}
    