
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PhotoSizeSelectActual {

  @JSImport("@material-ui/icons/PhotoSizeSelectActual", JSImport.Default)
  @js.native
  object PhotoSizeSelectActualJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PhotoSizeSelectActualJS)
  
  def apply() = jsFnComponent()

}
    