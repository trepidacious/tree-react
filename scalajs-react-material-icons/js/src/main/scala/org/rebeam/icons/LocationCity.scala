
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocationCity {

  @JSImport("@material-ui/icons/LocationCity", JSImport.Default)
  @js.native
  object LocationCityJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocationCityJS)
  
  def apply() = jsFnComponent()

}
    