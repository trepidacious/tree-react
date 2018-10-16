
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CameraRear {

  @JSImport("@material-ui/icons/CameraRear", JSImport.Default)
  @js.native
  object CameraRearJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CameraRearJS)
  
  def apply() = jsFnComponent()

}
    