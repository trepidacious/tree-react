
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ArrowForward {

  @JSImport("@material-ui/icons/ArrowForward", JSImport.Default)
  @js.native
  object ArrowForwardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArrowForwardJS)
  
  def apply() = jsFnComponent()

}
    