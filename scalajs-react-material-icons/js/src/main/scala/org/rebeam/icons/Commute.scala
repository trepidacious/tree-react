
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Commute {

  @JSImport("@material-ui/icons/Commute", JSImport.Default)
  @js.native
  object CommuteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CommuteJS)
  
  def apply() = jsFnComponent()

}
    