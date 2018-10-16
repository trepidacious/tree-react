
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocalHospital {

  @JSImport("@material-ui/icons/LocalHospital", JSImport.Default)
  @js.native
  object LocalHospitalJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocalHospitalJS)
  
  def apply() = jsFnComponent()

}
    