
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object LineStyle {

  @JSImport("@material-ui/icons/LineStyle", JSImport.Default)
  @js.native
  object LineStyleJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LineStyleJS)
  
  def apply() = jsFnComponent()

}
    