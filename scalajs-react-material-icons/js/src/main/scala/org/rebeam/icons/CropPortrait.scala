
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CropPortrait {

  @JSImport("@material-ui/icons/CropPortrait", JSImport.Default)
  @js.native
  object CropPortraitJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CropPortraitJS)
  
  def apply() = jsFnComponent()

}
    