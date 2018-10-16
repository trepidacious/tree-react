
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DesktopAccessDisabled {

  @JSImport("@material-ui/icons/DesktopAccessDisabled", JSImport.Default)
  @js.native
  object DesktopAccessDisabledJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DesktopAccessDisabledJS)
  
  def apply() = jsFnComponent()

}
    