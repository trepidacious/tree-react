
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Brightness4 {

  @JSImport("@material-ui/icons/Brightness4", JSImport.Default)
  @js.native
  object Brightness4JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Brightness4JS)
  
  def apply() = jsFnComponent()

}
    