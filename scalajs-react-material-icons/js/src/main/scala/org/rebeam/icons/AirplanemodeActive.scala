
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object AirplanemodeActive {

  @JSImport("@material-ui/icons/AirplanemodeActive", JSImport.Default)
  @js.native
  object AirplanemodeActiveJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](AirplanemodeActiveJS)
  
  def apply() = jsFnComponent()

}
    