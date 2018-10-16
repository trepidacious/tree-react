
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AirplanemodeInactive {

  @JSImport("@material-ui/icons/AirplanemodeInactive", JSImport.Default)
  @js.native
  object AirplanemodeInactiveJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AirplanemodeInactiveJS)
  
  def apply() = jsFnComponent()

}
    