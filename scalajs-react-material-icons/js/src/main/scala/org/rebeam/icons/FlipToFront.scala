
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object FlipToFront {

  @JSImport("@material-ui/icons/FlipToFront", JSImport.Default)
  @js.native
  object FlipToFrontJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](FlipToFrontJS)
  
  def apply() = jsFnComponent()

}
    