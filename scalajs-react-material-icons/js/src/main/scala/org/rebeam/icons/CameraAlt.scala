
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CameraAlt {

  @JSImport("@material-ui/icons/CameraAlt", JSImport.Default)
  @js.native
  object CameraAltJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CameraAltJS)
  
  def apply() = jsFnComponent()

}
    