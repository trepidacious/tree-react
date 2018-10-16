
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LooksTwo {

  @JSImport("@material-ui/icons/LooksTwo", JSImport.Default)
  @js.native
  object LooksTwoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LooksTwoJS)
  
  def apply() = jsFnComponent()

}
    