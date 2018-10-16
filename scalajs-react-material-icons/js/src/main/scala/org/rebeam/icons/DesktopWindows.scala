
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DesktopWindows {

  @JSImport("@material-ui/icons/DesktopWindows", JSImport.Default)
  @js.native
  object DesktopWindowsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DesktopWindowsJS)
  
  def apply() = jsFnComponent()

}
    