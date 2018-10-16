
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FlipToBack {

  @JSImport("@material-ui/icons/FlipToBack", JSImport.Default)
  @js.native
  object FlipToBackJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FlipToBackJS)
  
  def apply() = jsFnComponent()

}
    