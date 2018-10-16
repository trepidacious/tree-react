
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Brightness5 {

  @JSImport("@material-ui/icons/Brightness5", JSImport.Default)
  @js.native
  object Brightness5JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Brightness5JS)
  
  def apply() = jsFnComponent()

}
    