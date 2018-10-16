
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object VideoCall {

  @JSImport("@material-ui/icons/VideoCall", JSImport.Default)
  @js.native
  object VideoCallJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VideoCallJS)
  
  def apply() = jsFnComponent()

}
    