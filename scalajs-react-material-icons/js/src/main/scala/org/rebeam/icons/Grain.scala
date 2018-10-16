
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object Grain {

  @JSImport("@material-ui/icons/Grain", JSImport.Default)
  @js.native
  object GrainJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](GrainJS)
  
  def apply() = jsFnComponent()

}
    