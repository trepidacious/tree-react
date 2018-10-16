
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CallMissed {

  @JSImport("@material-ui/icons/CallMissed", JSImport.Default)
  @js.native
  object CallMissedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CallMissedJS)
  
  def apply() = jsFnComponent()

}
    