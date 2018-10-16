
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ViewQuilt {

  @JSImport("@material-ui/icons/ViewQuilt", JSImport.Default)
  @js.native
  object ViewQuiltJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ViewQuiltJS)
  
  def apply() = jsFnComponent()

}
    