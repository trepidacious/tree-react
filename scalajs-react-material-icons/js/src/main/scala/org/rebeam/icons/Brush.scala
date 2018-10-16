
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Brush {

  @JSImport("@material-ui/icons/Brush", JSImport.Default)
  @js.native
  object BrushJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](BrushJS)
  
  def apply() = jsFnComponent()

}
    