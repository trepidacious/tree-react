
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object StayPrimaryPortrait {

  @JSImport("@material-ui/icons/StayPrimaryPortrait", JSImport.Default)
  @js.native
  object StayPrimaryPortraitJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StayPrimaryPortraitJS)
  
  def apply() = jsFnComponent()

}
    