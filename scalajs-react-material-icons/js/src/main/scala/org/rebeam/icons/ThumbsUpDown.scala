
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ThumbsUpDown {

  @JSImport("@material-ui/icons/ThumbsUpDown", JSImport.Default)
  @js.native
  object ThumbsUpDownJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ThumbsUpDownJS)
  
  def apply() = jsFnComponent()

}
    