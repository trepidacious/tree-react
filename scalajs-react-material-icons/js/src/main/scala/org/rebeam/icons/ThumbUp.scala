
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ThumbUp {

  @JSImport("@material-ui/icons/ThumbUp", JSImport.Default)
  @js.native
  object ThumbUpJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ThumbUpJS)
  
  def apply() = jsFnComponent()

}
    