
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object GpsFixed {

  @JSImport("@material-ui/icons/GpsFixed", JSImport.Default)
  @js.native
  object GpsFixedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GpsFixedJS)
  
  def apply() = jsFnComponent()

}
    