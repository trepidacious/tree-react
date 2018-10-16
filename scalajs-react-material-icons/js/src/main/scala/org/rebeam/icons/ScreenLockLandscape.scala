
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ScreenLockLandscape {

  @JSImport("@material-ui/icons/ScreenLockLandscape", JSImport.Default)
  @js.native
  object ScreenLockLandscapeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ScreenLockLandscapeJS)
  
  def apply() = jsFnComponent()

}
    