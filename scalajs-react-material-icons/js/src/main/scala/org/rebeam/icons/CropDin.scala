
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CropDin {

  @JSImport("@material-ui/icons/CropDin", JSImport.Default)
  @js.native
  object CropDinJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CropDinJS)
  
  def apply() = jsFnComponent()

}
    