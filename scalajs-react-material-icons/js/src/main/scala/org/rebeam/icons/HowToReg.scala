
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object HowToReg {

  @JSImport("@material-ui/icons/HowToReg", JSImport.Default)
  @js.native
  object HowToRegJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](HowToRegJS)
  
  def apply() = jsFnComponent()

}
    