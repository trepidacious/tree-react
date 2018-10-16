
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CallMissedOutgoing {

  @JSImport("@material-ui/icons/CallMissedOutgoing", JSImport.Default)
  @js.native
  object CallMissedOutgoingJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CallMissedOutgoingJS)
  
  def apply() = jsFnComponent()

}
    