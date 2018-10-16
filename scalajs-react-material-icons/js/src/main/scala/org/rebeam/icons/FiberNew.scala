
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FiberNew {

  @JSImport("@material-ui/icons/FiberNew", JSImport.Default)
  @js.native
  object FiberNewJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FiberNewJS)
  
  def apply() = jsFnComponent()

}
    