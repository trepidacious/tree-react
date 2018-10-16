
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object CropSquare {

  @JSImport("@material-ui/icons/CropSquare", JSImport.Default)
  @js.native
  object CropSquareJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](CropSquareJS)
  
  def apply() = jsFnComponent()

}
    