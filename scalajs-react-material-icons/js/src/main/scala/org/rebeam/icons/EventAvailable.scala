
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object EventAvailable {

  @JSImport("@material-ui/icons/EventAvailable", JSImport.Default)
  @js.native
  object EventAvailableJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EventAvailableJS)
  
  def apply() = jsFnComponent()

}
    