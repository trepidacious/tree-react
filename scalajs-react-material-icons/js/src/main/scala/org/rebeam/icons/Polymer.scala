
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Polymer {

  @JSImport("@material-ui/icons/Polymer", JSImport.Default)
  @js.native
  object PolymerJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PolymerJS)
  
  def apply() = jsFnComponent()

}
    