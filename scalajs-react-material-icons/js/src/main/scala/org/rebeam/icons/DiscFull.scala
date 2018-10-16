
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object DiscFull {

  @JSImport("@material-ui/icons/DiscFull", JSImport.Default)
  @js.native
  object DiscFullJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](DiscFullJS)
  
  def apply() = jsFnComponent()

}
    