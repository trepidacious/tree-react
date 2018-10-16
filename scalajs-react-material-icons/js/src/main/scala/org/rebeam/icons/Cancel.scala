
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Cancel {

  @JSImport("@material-ui/icons/Cancel", JSImport.Default)
  @js.native
  object CancelJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CancelJS)
  
  def apply() = jsFnComponent()

}
    