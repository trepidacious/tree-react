
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ThumbDown {

  @JSImport("@material-ui/icons/ThumbDown", JSImport.Default)
  @js.native
  object ThumbDownJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ThumbDownJS)
  
  def apply() = jsFnComponent()

}
    