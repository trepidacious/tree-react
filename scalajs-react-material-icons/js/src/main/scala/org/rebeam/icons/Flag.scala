
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Flag {

  @JSImport("@material-ui/icons/Flag", JSImport.Default)
  @js.native
  object FlagJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FlagJS)
  
  def apply() = jsFnComponent()

}
    