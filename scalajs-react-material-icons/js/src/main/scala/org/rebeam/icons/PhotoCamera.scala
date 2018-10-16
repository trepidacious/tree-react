
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhotoCamera {

  @JSImport("@material-ui/icons/PhotoCamera", JSImport.Default)
  @js.native
  object PhotoCameraJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhotoCameraJS)
  
  def apply() = jsFnComponent()

}
    