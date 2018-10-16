
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ThreeDRotation {

  @JSImport("@material-ui/icons/ThreeDRotation", JSImport.Default)
  @js.native
  object ThreeDRotationJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ThreeDRotationJS)
  
  def apply() = jsFnComponent()

}
    