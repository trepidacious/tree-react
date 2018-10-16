
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Timer {

  @JSImport("@material-ui/icons/Timer", JSImport.Default)
  @js.native
  object TimerJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TimerJS)
  
  def apply() = jsFnComponent()

}
    