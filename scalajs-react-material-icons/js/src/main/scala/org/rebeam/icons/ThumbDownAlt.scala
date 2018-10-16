
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ThumbDownAlt {

  @JSImport("@material-ui/icons/ThumbDownAlt", JSImport.Default)
  @js.native
  object ThumbDownAltJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ThumbDownAltJS)
  
  def apply() = jsFnComponent()

}
    