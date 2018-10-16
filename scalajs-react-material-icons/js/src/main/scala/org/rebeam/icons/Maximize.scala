
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Maximize {

  @JSImport("@material-ui/icons/Maximize", JSImport.Default)
  @js.native
  object MaximizeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MaximizeJS)
  
  def apply() = jsFnComponent()

}
    