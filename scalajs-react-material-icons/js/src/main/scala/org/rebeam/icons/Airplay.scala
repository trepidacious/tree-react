
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Airplay {

  @JSImport("@material-ui/icons/Airplay", JSImport.Default)
  @js.native
  object AirplayJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AirplayJS)
  
  def apply() = jsFnComponent()

}
    