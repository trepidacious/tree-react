
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Hearing {

  @JSImport("@material-ui/icons/Hearing", JSImport.Default)
  @js.native
  object HearingJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HearingJS)
  
  def apply() = jsFnComponent()

}
    