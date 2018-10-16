
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CropRotate {

  @JSImport("@material-ui/icons/CropRotate", JSImport.Default)
  @js.native
  object CropRotateJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CropRotateJS)
  
  def apply() = jsFnComponent()

}
    