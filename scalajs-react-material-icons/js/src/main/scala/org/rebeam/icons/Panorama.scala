
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Panorama {

  @JSImport("@material-ui/icons/Panorama", JSImport.Default)
  @js.native
  object PanoramaJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PanoramaJS)
  
  def apply() = jsFnComponent()

}
    