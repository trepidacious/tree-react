
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Event {

  @JSImport("@material-ui/icons/Event", JSImport.Default)
  @js.native
  object EventJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](EventJS)
  
  def apply() = jsFnComponent()

}
    