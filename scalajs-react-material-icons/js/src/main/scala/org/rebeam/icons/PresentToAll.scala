
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PresentToAll {

  @JSImport("@material-ui/icons/PresentToAll", JSImport.Default)
  @js.native
  object PresentToAllJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PresentToAllJS)
  
  def apply() = jsFnComponent()

}
    