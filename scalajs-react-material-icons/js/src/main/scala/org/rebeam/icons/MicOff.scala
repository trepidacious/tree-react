
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object MicOff {

  @JSImport("@material-ui/icons/MicOff", JSImport.Default)
  @js.native
  object MicOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MicOffJS)
  
  def apply() = jsFnComponent()

}
    