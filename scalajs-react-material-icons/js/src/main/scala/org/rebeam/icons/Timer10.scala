
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Timer10 {

  @JSImport("@material-ui/icons/Timer10", JSImport.Default)
  @js.native
  object Timer10JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Timer10JS)
  
  def apply() = jsFnComponent()

}
    