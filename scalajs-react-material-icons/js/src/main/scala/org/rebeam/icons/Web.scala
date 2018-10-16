
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Web {

  @JSImport("@material-ui/icons/Web", JSImport.Default)
  @js.native
  object WebJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WebJS)
  
  def apply() = jsFnComponent()

}
    