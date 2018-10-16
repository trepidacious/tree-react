
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ArrowRightAlt {

  @JSImport("@material-ui/icons/ArrowRightAlt", JSImport.Default)
  @js.native
  object ArrowRightAltJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArrowRightAltJS)
  
  def apply() = jsFnComponent()

}
    