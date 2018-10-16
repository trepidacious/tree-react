
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ScreenLockPortrait {

  @JSImport("@material-ui/icons/ScreenLockPortrait", JSImport.Default)
  @js.native
  object ScreenLockPortraitJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ScreenLockPortraitJS)
  
  def apply() = jsFnComponent()

}
    