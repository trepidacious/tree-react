
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LinkedCamera {

  @JSImport("@material-ui/icons/LinkedCamera", JSImport.Default)
  @js.native
  object LinkedCameraJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LinkedCameraJS)
  
  def apply() = jsFnComponent()

}
    