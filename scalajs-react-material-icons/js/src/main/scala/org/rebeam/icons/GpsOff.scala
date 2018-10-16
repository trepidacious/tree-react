
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object GpsOff {

  @JSImport("@material-ui/icons/GpsOff", JSImport.Default)
  @js.native
  object GpsOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GpsOffJS)
  
  def apply() = jsFnComponent()

}
    