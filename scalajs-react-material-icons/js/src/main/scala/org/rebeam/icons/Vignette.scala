
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Vignette {

  @JSImport("@material-ui/icons/Vignette", JSImport.Default)
  @js.native
  object VignetteJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](VignetteJS)
  
  def apply() = jsFnComponent()

}
    