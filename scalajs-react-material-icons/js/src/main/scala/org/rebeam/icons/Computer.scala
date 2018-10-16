
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Computer {

  @JSImport("@material-ui/icons/Computer", JSImport.Default)
  @js.native
  object ComputerJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ComputerJS)
  
  def apply() = jsFnComponent()

}
    