
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Crop {

  @JSImport("@material-ui/icons/Crop", JSImport.Default)
  @js.native
  object CropJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CropJS)
  
  def apply() = jsFnComponent()

}
    