
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object GpsNotFixed {

  @JSImport("@material-ui/icons/GpsNotFixed", JSImport.Default)
  @js.native
  object GpsNotFixedJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GpsNotFixedJS)
  
  def apply() = jsFnComponent()

}
    