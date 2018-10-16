
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AcUnit {

  @JSImport("@material-ui/icons/AcUnit", JSImport.Default)
  @js.native
  object AcUnitJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AcUnitJS)
  
  def apply() = jsFnComponent()

}
    