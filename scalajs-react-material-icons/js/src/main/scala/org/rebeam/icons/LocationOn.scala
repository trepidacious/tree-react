
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LocationOn {

  @JSImport("@material-ui/icons/LocationOn", JSImport.Default)
  @js.native
  object LocationOnJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LocationOnJS)
  
  def apply() = jsFnComponent()

}
    