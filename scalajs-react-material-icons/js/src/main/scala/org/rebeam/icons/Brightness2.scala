
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Brightness2 {

  @JSImport("@material-ui/icons/Brightness2", JSImport.Default)
  @js.native
  object Brightness2JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Brightness2JS)
  
  def apply() = jsFnComponent()

}
    