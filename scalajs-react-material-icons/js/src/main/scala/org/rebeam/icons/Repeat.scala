
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Repeat {

  @JSImport("@material-ui/icons/Repeat", JSImport.Default)
  @js.native
  object RepeatJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RepeatJS)
  
  def apply() = jsFnComponent()

}
    