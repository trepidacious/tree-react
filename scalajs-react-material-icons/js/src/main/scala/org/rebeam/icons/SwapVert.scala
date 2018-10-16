
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object SwapVert {

  @JSImport("@material-ui/icons/SwapVert", JSImport.Default)
  @js.native
  object SwapVertJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](SwapVertJS)
  
  def apply() = jsFnComponent()

}
    