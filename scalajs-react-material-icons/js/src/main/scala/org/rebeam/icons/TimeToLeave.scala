
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TimeToLeave {

  @JSImport("@material-ui/icons/TimeToLeave", JSImport.Default)
  @js.native
  object TimeToLeaveJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TimeToLeaveJS)
  
  def apply() = jsFnComponent()

}
    