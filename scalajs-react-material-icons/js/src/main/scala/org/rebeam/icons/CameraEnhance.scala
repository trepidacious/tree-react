
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CameraEnhance {

  @JSImport("@material-ui/icons/CameraEnhance", JSImport.Default)
  @js.native
  object CameraEnhanceJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CameraEnhanceJS)
  
  def apply() = jsFnComponent()

}
    