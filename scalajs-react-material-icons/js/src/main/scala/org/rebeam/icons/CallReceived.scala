
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CallReceived {

  @JSImport("@material-ui/icons/CallReceived", JSImport.Default)
  @js.native
  object CallReceivedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CallReceivedJS)
  
  def apply() = jsFnComponent()

}
    