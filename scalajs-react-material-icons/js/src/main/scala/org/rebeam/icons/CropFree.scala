
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CropFree {

  @JSImport("@material-ui/icons/CropFree", JSImport.Default)
  @js.native
  object CropFreeJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CropFreeJS)
  
  def apply() = jsFnComponent()

}
    