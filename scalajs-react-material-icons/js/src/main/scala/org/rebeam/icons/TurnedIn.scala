
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object TurnedIn {

  @JSImport("@material-ui/icons/TurnedIn", JSImport.Default)
  @js.native
  object TurnedInJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TurnedInJS)
  
  def apply() = jsFnComponent()

}
    