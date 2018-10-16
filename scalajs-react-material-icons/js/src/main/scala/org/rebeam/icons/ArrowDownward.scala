
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ArrowDownward {

  @JSImport("@material-ui/icons/ArrowDownward", JSImport.Default)
  @js.native
  object ArrowDownwardJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArrowDownwardJS)
  
  def apply() = jsFnComponent()

}
    