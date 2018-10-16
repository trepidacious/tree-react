
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Layers {

  @JSImport("@material-ui/icons/Layers", JSImport.Default)
  @js.native
  object LayersJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](LayersJS)
  
  def apply() = jsFnComponent()

}
    