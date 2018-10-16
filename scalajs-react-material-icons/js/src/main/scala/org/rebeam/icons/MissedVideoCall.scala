
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MissedVideoCall {

  @JSImport("@material-ui/icons/MissedVideoCall", JSImport.Default)
  @js.native
  object MissedVideoCallJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MissedVideoCallJS)
  
  def apply() = jsFnComponent()

}
    