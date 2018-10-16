
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object StayPrimaryLandscape {

  @JSImport("@material-ui/icons/StayPrimaryLandscape", JSImport.Default)
  @js.native
  object StayPrimaryLandscapeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](StayPrimaryLandscapeJS)
  
  def apply() = jsFnComponent()

}
    