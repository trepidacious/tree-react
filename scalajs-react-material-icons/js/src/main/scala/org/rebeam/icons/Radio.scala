
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Radio {

  @JSImport("@material-ui/icons/Radio", JSImport.Default)
  @js.native
  object RadioJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](RadioJS)
  
  def apply() = jsFnComponent()

}
    