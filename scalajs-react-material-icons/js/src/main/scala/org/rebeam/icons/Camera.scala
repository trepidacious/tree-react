
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Camera {

  @JSImport("@material-ui/icons/Camera", JSImport.Default)
  @js.native
  object CameraJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CameraJS)
  
  def apply() = jsFnComponent()

}
    