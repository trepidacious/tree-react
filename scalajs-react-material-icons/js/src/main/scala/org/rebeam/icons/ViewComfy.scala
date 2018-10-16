
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ViewComfy {

  @JSImport("@material-ui/icons/ViewComfy", JSImport.Default)
  @js.native
  object ViewComfyJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ViewComfyJS)
  
  def apply() = jsFnComponent()

}
    