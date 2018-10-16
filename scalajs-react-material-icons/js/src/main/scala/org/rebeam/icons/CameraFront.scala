
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CameraFront {

  @JSImport("@material-ui/icons/CameraFront", JSImport.Default)
  @js.native
  object CameraFrontJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CameraFrontJS)
  
  def apply() = jsFnComponent()

}
    