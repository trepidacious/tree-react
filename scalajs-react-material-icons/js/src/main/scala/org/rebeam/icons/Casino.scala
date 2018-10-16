
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Casino {

  @JSImport("@material-ui/icons/Casino", JSImport.Default)
  @js.native
  object CasinoJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CasinoJS)
  
  def apply() = jsFnComponent()

}
    