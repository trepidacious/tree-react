
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PowerInput {

  @JSImport("@material-ui/icons/PowerInput", JSImport.Default)
  @js.native
  object PowerInputJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PowerInputJS)
  
  def apply() = jsFnComponent()

}
    