
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object GridOff {

  @JSImport("@material-ui/icons/GridOff", JSImport.Default)
  @js.native
  object GridOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GridOffJS)
  
  def apply() = jsFnComponent()

}
    