
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FiberDvr {

  @JSImport("@material-ui/icons/FiberDvr", JSImport.Default)
  @js.native
  object FiberDvrJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FiberDvrJS)
  
  def apply() = jsFnComponent()

}
    