
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CallMade {

  @JSImport("@material-ui/icons/CallMade", JSImport.Default)
  @js.native
  object CallMadeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CallMadeJS)
  
  def apply() = jsFnComponent()

}
    