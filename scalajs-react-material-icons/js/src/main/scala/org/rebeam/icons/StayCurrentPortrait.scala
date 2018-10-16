
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object StayCurrentPortrait {

  @JSImport("@material-ui/icons/StayCurrentPortrait", JSImport.Default)
  @js.native
  object StayCurrentPortraitJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StayCurrentPortraitJS)
  
  def apply() = jsFnComponent()

}
    