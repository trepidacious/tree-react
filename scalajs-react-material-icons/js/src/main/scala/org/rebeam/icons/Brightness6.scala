
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Brightness6 {

  @JSImport("@material-ui/icons/Brightness6", JSImport.Default)
  @js.native
  object Brightness6JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Brightness6JS)
  
  def apply() = jsFnComponent()

}
    