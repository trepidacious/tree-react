
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Timelapse {

  @JSImport("@material-ui/icons/Timelapse", JSImport.Default)
  @js.native
  object TimelapseJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](TimelapseJS)
  
  def apply() = jsFnComponent()

}
    