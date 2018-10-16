
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FiberPin {

  @JSImport("@material-ui/icons/FiberPin", JSImport.Default)
  @js.native
  object FiberPinJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FiberPinJS)
  
  def apply() = jsFnComponent()

}
    