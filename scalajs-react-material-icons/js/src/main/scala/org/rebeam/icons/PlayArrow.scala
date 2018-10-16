
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object PlayArrow {

  @JSImport("@material-ui/icons/PlayArrow", JSImport.Default)
  @js.native
  object PlayArrowJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](PlayArrowJS)
  
  def apply() = jsFnComponent()

}
    