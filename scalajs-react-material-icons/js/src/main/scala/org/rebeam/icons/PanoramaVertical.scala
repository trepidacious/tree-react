
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PanoramaVertical {

  @JSImport("@material-ui/icons/PanoramaVertical", JSImport.Default)
  @js.native
  object PanoramaVerticalJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PanoramaVerticalJS)
  
  def apply() = jsFnComponent()

}
    