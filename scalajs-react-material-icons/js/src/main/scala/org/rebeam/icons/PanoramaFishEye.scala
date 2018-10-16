
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PanoramaFishEye {

  @JSImport("@material-ui/icons/PanoramaFishEye", JSImport.Default)
  @js.native
  object PanoramaFishEyeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PanoramaFishEyeJS)
  
  def apply() = jsFnComponent()

}
    