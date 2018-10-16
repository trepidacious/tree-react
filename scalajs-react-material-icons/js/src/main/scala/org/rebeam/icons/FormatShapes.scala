
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FormatShapes {

  @JSImport("@material-ui/icons/FormatShapes", JSImport.Default)
  @js.native
  object FormatShapesJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FormatShapesJS)
  
  def apply() = jsFnComponent()

}
    