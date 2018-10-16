
package org.rebeam.icons

import japgolly.scalajs.react._
import scalajs.js
import scalajs.js.annotation.JSImport

object ArrowDropUp {

  @JSImport("@material-ui/icons/ArrowDropUp", JSImport.Default)
  @js.native
  object ArrowDropUpJS extends js.Object

  val jsFnComponent = JsFnComponent[Null, Children.None](ArrowDropUpJS)
  
  def apply() = jsFnComponent()

}
    