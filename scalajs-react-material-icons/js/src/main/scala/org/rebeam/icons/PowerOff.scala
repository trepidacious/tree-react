
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PowerOff {

  @JSImport("@material-ui/icons/PowerOff", JSImport.Default)
  @js.native
  object PowerOffJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PowerOffJS)
  
  def apply() = jsFnComponent()

}
    