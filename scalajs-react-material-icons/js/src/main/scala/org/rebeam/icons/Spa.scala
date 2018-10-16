
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Spa {

  @JSImport("@material-ui/icons/Spa", JSImport.Default)
  @js.native
  object SpaJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SpaJS)
  
  def apply() = jsFnComponent()

}
    