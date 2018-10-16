
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AddBox {

  @JSImport("@material-ui/icons/AddBox", JSImport.Default)
  @js.native
  object AddBoxJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AddBoxJS)
  
  def apply() = jsFnComponent()

}
    