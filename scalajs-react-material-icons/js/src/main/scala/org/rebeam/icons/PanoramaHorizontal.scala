
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PanoramaHorizontal {

  @JSImport("@material-ui/icons/PanoramaHorizontal", JSImport.Default)
  @js.native
  object PanoramaHorizontalJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PanoramaHorizontalJS)
  
  def apply() = jsFnComponent()

}
    