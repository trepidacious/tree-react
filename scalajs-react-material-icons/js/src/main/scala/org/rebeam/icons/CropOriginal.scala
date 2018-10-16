
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CropOriginal {

  @JSImport("@material-ui/icons/CropOriginal", JSImport.Default)
  @js.native
  object CropOriginalJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CropOriginalJS)
  
  def apply() = jsFnComponent()

}
    