
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ThumbUpAlt {

  @JSImport("@material-ui/icons/ThumbUpAlt", JSImport.Default)
  @js.native
  object ThumbUpAltJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ThumbUpAltJS)
  
  def apply() = jsFnComponent()

}
    