
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ColorLens {

  @JSImport("@material-ui/icons/ColorLens", JSImport.Default)
  @js.native
  object ColorLensJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ColorLensJS)
  
  def apply() = jsFnComponent()

}
    