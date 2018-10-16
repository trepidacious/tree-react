
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object NotListedLocation {

  @JSImport("@material-ui/icons/NotListedLocation", JSImport.Default)
  @js.native
  object NotListedLocationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](NotListedLocationJS)
  
  def apply() = jsFnComponent()

}
    