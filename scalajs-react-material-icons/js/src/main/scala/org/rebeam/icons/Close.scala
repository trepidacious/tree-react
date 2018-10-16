
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Close {

  @JSImport("@material-ui/icons/Close", JSImport.Default)
  @js.native
  object CloseJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CloseJS)
  
  def apply() = jsFnComponent()

}
    