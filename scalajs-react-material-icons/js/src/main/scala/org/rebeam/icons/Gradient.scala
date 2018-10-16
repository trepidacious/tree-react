
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Gradient {

  @JSImport("@material-ui/icons/Gradient", JSImport.Default)
  @js.native
  object GradientJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GradientJS)
  
  def apply() = jsFnComponent()

}
    