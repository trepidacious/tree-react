
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Brightness1 {

  @JSImport("@material-ui/icons/Brightness1", JSImport.Default)
  @js.native
  object Brightness1JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Brightness1JS)
  
  def apply() = jsFnComponent()

}
    