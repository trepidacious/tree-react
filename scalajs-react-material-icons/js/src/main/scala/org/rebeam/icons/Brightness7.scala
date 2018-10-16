
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Brightness7 {

  @JSImport("@material-ui/icons/Brightness7", JSImport.Default)
  @js.native
  object Brightness7JS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](Brightness7JS)
  
  def apply() = jsFnComponent()

}
    