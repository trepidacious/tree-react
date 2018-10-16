
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object WbAuto {

  @JSImport("@material-ui/icons/WbAuto", JSImport.Default)
  @js.native
  object WbAutoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WbAutoJS)
  
  def apply() = jsFnComponent()

}
    