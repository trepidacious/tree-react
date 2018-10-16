
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Cake {

  @JSImport("@material-ui/icons/Cake", JSImport.Default)
  @js.native
  object CakeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CakeJS)
  
  def apply() = jsFnComponent()

}
    