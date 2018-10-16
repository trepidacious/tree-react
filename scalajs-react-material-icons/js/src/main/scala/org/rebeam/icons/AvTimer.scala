
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AvTimer {

  @JSImport("@material-ui/icons/AvTimer", JSImport.Default)
  @js.native
  object AvTimerJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AvTimerJS)
  
  def apply() = jsFnComponent()

}
    