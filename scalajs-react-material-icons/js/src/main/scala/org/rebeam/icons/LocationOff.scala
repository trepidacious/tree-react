
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocationOff {

  @JSImport("@material-ui/icons/LocationOff", JSImport.Default)
  @js.native
  object LocationOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocationOffJS)
  
  def apply() = jsFnComponent()

}
    