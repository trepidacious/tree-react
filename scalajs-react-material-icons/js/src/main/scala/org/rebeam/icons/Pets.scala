
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Pets {

  @JSImport("@material-ui/icons/Pets", JSImport.Default)
  @js.native
  object PetsJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PetsJS)
  
  def apply() = jsFnComponent()

}
    