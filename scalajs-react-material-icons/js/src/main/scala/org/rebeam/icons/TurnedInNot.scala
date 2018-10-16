
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TurnedInNot {

  @JSImport("@material-ui/icons/TurnedInNot", JSImport.Default)
  @js.native
  object TurnedInNotJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TurnedInNotJS)
  
  def apply() = jsFnComponent()

}
    