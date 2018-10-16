
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object StayCurrentLandscape {

  @JSImport("@material-ui/icons/StayCurrentLandscape", JSImport.Default)
  @js.native
  object StayCurrentLandscapeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StayCurrentLandscapeJS)
  
  def apply() = jsFnComponent()

}
    