
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object RepeatOne {

  @JSImport("@material-ui/icons/RepeatOne", JSImport.Default)
  @js.native
  object RepeatOneJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RepeatOneJS)
  
  def apply() = jsFnComponent()

}
    