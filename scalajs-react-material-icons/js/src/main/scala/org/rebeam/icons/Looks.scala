
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Looks {

  @JSImport("@material-ui/icons/Looks", JSImport.Default)
  @js.native
  object LooksJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LooksJS)
  
  def apply() = jsFnComponent()

}
    