
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Print {

  @JSImport("@material-ui/icons/Print", JSImport.Default)
  @js.native
  object PrintJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PrintJS)
  
  def apply() = jsFnComponent()

}
    