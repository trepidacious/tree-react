
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalAtm {

  @JSImport("@material-ui/icons/LocalAtm", JSImport.Default)
  @js.native
  object LocalAtmJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalAtmJS)
  
  def apply() = jsFnComponent()

}
    