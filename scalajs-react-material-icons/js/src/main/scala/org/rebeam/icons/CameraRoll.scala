
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CameraRoll {

  @JSImport("@material-ui/icons/CameraRoll", JSImport.Default)
  @js.native
  object CameraRollJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CameraRollJS)
  
  def apply() = jsFnComponent()

}
    