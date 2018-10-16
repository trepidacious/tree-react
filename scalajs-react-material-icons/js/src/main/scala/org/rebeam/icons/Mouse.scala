
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Mouse {

  @JSImport("@material-ui/icons/Mouse", JSImport.Default)
  @js.native
  object MouseJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](MouseJS)
  
  def apply() = jsFnComponent()

}
    