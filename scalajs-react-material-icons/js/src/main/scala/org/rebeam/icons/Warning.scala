
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Warning {

  @JSImport("@material-ui/icons/Warning", JSImport.Default)
  @js.native
  object WarningJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](WarningJS)
  
  def apply() = jsFnComponent()

}
    