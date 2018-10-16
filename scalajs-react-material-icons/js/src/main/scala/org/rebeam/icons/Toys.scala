
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Toys {

  @JSImport("@material-ui/icons/Toys", JSImport.Default)
  @js.native
  object ToysJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ToysJS)
  
  def apply() = jsFnComponent()

}
    