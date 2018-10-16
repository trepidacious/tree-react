
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ControlPoint {

  @JSImport("@material-ui/icons/ControlPoint", JSImport.Default)
  @js.native
  object ControlPointJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ControlPointJS)
  
  def apply() = jsFnComponent()

}
    