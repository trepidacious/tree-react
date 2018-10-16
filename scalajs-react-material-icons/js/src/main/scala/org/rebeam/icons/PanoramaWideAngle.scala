
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PanoramaWideAngle {

  @JSImport("@material-ui/icons/PanoramaWideAngle", JSImport.Default)
  @js.native
  object PanoramaWideAngleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PanoramaWideAngleJS)
  
  def apply() = jsFnComponent()

}
    