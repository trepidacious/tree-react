
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ArrowRight {

  @JSImport("@material-ui/icons/ArrowRight", JSImport.Default)
  @js.native
  object ArrowRightJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArrowRightJS)
  
  def apply() = jsFnComponent()

}
    