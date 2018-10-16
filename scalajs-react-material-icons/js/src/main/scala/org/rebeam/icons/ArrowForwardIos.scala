
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ArrowForwardIos {

  @JSImport("@material-ui/icons/ArrowForwardIos", JSImport.Default)
  @js.native
  object ArrowForwardIosJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArrowForwardIosJS)
  
  def apply() = jsFnComponent()

}
    