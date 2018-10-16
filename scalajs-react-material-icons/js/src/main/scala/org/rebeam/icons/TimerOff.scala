
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TimerOff {

  @JSImport("@material-ui/icons/TimerOff", JSImport.Default)
  @js.native
  object TimerOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TimerOffJS)
  
  def apply() = jsFnComponent()

}
    