
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NoSim {

  @JSImport("@material-ui/icons/NoSim", JSImport.Default)
  @js.native
  object NoSimJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NoSimJS)
  
  def apply() = jsFnComponent()

}
    