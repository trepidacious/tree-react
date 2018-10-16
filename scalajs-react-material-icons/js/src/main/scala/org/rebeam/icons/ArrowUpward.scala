
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ArrowUpward {

  @JSImport("@material-ui/icons/ArrowUpward", JSImport.Default)
  @js.native
  object ArrowUpwardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArrowUpwardJS)
  
  def apply() = jsFnComponent()

}
    