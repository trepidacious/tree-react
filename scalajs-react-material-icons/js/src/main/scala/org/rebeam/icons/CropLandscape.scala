
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CropLandscape {

  @JSImport("@material-ui/icons/CropLandscape", JSImport.Default)
  @js.native
  object CropLandscapeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CropLandscapeJS)
  
  def apply() = jsFnComponent()

}
    